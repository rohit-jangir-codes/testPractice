import java.net.http.*;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class CyberWall {
    // ===== Visuals =====
    private static final String GREEN = "\u001B[32m";
    private static final String DIM   = "\u001B[2m";
    private static final String BOLD  = "\u001B[1m";
    private static final String RESET = "\u001B[0m";

    private static final Random RNG = new Random();

    // ===== Shared state for fetched data =====
    private static final Map<String, String> DATA = new ConcurrentHashMap<>();

    // ===== HTTP client =====
    private static final HttpClient HTTP = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public static void main(String[] args) throws Exception {
        maybeEnableAnsiOnWindows();
        clearScreen();

        // Default location (New Delhi) if user doesn't pass lat lon
        double lat = 28.6139, lon = 77.2090;
        if (args.length == 2) {
            try {
                lat = Double.parseDouble(args[0]);
                lon = Double.parseDouble(args[1]);
            } catch (NumberFormatException ignored) {}
        }

        System.out.println(GREEN + BOLD + ">>> CYBERWALL ONLINE — REAL-TIME FEED INITIALIZED <<<" + RESET);
        System.out.println(DIM + "Press CTRL + C to stop." + RESET);
        System.out.println();

        // Schedule periodic data pulls
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(4);

        // Weather (Open-Meteo – no API key)
        String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + lat +
                "&longitude=" + lon + "&current_weather=true";
        exec.scheduleAtFixedRate(() -> safeFetch("WEATHER", () -> {
            String j = httpGet(weatherUrl);
            String temp = jsonNumber(j, "temperature");  // current_weather.temperature
            if (temp == null) temp = jsonNumber(jsonObject(j, "current_weather"), "temperature");
            String wind = jsonNumber(j, "windspeed");
            if (wind == null) wind = jsonNumber(jsonObject(j, "current_weather"), "windspeed");
            return String.format("Temp: %s°C, Wind: %s km/h", nz(temp, "?"), nz(wind, "?"));
        }), 0, 90, TimeUnit.SECONDS);

        // ISS position (Open Notify – no key)
        String issUrl = "http://api.open-notify.org/iss-now.json";
        exec.scheduleAtFixedRate(() -> safeFetch("ISS", () -> {
            String j = httpGet(issUrl);
            String pos = jsonObject(j, "iss_position");
            String latS = jsonString(pos, "latitude");
            String lonS = jsonString(pos, "longitude");
            return "ISS @ lat " + nz(latS, "?") + ", lon " + nz(lonS, "?");
        }), 5, 60, TimeUnit.SECONDS);

        // Hacker News top stories (official Firebase mirror – no key)
        String hnTop = "https://hacker-news.firebaseio.com/v0/topstories.json";
        exec.scheduleAtFixedRate(() -> safeFetch("HN", () -> {
            String body = httpGet(hnTop);
            int count = arrayCount(body);
            return "Top stories: " + count;
        }), 10, 120, TimeUnit.SECONDS);

        // Bored API (no key)
        String bored = "https://www.boredapi.com/api/activity";
        exec.scheduleAtFixedRate(() -> safeFetch("TASK", () -> {
            String j = httpGet(bored);
            String act = jsonString(j, "activity");
            String type = jsonString(j, "type");
            return "Try: " + nz(act, "something interesting") + " (" + nz(type, "misc") + ")";
        }), 15, 150, TimeUnit.SECONDS);

        // Cat Fact (no key)
        String cat = "https://catfact.ninja/fact";
        exec.scheduleAtFixedRate(() -> safeFetch("FACT", () -> {
            String j = httpGet(cat);
            String fact = jsonString(j, "fact");
            return fact != null && fact.length() > 120 ? fact.substring(0, 117) + "..." : nz(fact, "Cats are mysterious.");
        }), 20, 180, TimeUnit.SECONDS);

        // ===== Continuous stream =====
        int lineCount = 0;
        while (true) {
            printMatrixLine(100);
            Thread.sleep(60 + RNG.nextInt(40));
            lineCount++;

            // Every N lines, inject an info panel
            if (lineCount % 20 == 0) {
                printInfoPanel();
            }
        }
    }

    // ======================== Visuals =========================
    private static void printMatrixLine(int width) {
        StringBuilder sb = new StringBuilder(width * 2);
        for (int i = 0; i < width; i++) {
            int chType = RNG.nextInt(6);
            char c;
            if (chType <= 2) { // digits + symbols
                c = (char) (33 + RNG.nextInt(94)); // printable ASCII
            } else if (chType == 3) { // hex-ish
                String hex = "0123456789ABCDEF";
                c = hex.charAt(RNG.nextInt(hex.length()));
            } else { // pseudo code letters
                String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                c = letters.charAt(RNG.nextInt(letters.length()));
            }
            sb.append(c).append(' ');
        }
        System.out.println(GREEN + sb + RESET);
    }

    private static void printInfoPanel() {
        String ts = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss").format(LocalDateTime.now());
        List<String> lines = new ArrayList<>();
        lines.add("TIME   : " + ts);
        lines.add("WEATHER: " + nz(DATA.get("WEATHER"), "loading..."));
        lines.add("ISS    : " + nz(DATA.get("ISS"), "loading..."));
        lines.add("HN     : " + nz(DATA.get("HN"), "loading..."));
        lines.add("TASK   : " + nz(DATA.get("TASK"), "loading..."));
        lines.add("FACT   : " + nz(DATA.get("FACT"), "loading..."));

        String border = "═".repeat(76);
        System.out.println(BOLD + GREEN + "╔" + border + "╗" + RESET);
        for (String line : lines) {
            System.out.println(BOLD + GREEN + "║ " + RESET + linePad(line, 74) + BOLD + GREEN + " ║" + RESET);
        }
        System.out.println(BOLD + GREEN + "╚" + border + "╝" + RESET);
    }

    private static String linePad(String s, int len) {
        if (s.length() >= len) return s.substring(0, len);
        return s + " ".repeat(len - s.length());
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ignored) {}
    }

    // ======================== Fetch logic =========================
    @FunctionalInterface
    interface SupplierX<T> { T get() throws Exception; }

    private static void safeFetch(String key, SupplierX<String> action) {
        try {
            String val = action.get();
            if (val != null && !val.isBlank()) DATA.put(key, val);
        } catch (Exception e) {
            DATA.put(key, "error: " + e.getClass().getSimpleName());
        }
    }

    private static String httpGet(String url) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder(URI.create(url))
                .timeout(Duration.ofSeconds(8))
                .header("User-Agent", "CyberWall/1.0 (+https://example.local)")
                .GET()
                .build();
        HttpResponse<String> res = HTTP.send(req, HttpResponse.BodyHandlers.ofString());
        if (res.statusCode() >= 200 && res.statusCode() < 300) {
            return res.body();
        }
        throw new IOException("HTTP " + res.statusCode());
    }

    // ======================== Tiny JSON helpers (no deps) =========================
    // These are deliberately simple and only handle the fields we need.

    private static String jsonObject(String json, String key) {
        if (json == null) return null;
        Pattern p = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*\\{");
        Matcher m = p.matcher(json);
        if (!m.find()) return null;
        int start = m.end() - 1; // at '{'
        int depth = 0;
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') depth++;
            else if (c == '}') {
                depth--;
                if (depth == 0) {
                    return json.substring(start, i + 1);
                }
            }
        }
        return null;
    }

    private static String jsonString(String json, String key) {
        if (json == null) return null;
        Pattern p = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher m = p.matcher(json);
        if (m.find()) return m.group(1);
        return null;
    }

    private static String jsonNumber(String json, String key) {
        if (json == null) return null;
        Pattern p = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*(-?\\d+(?:\\.\\d+)?)");
        Matcher m = p.matcher(json);
        if (m.find()) return m.group(1);
        return null;
    }

    private static int arrayCount(String jsonArray) {
        if (jsonArray == null || jsonArray.isBlank()) return 0;
        // Count commas + 1 for a flat numeric array
        int c = 0;
        for (int i = 0; i < jsonArray.length(); i++) if (jsonArray.charAt(i) == ',') c++;
        // Handle [] (empty)
        if (jsonArray.trim().equals("[]")) return 0;
        return c + 1;
    }

    private static String nz(String v, String d) { return (v == null || v.isBlank()) ? d : v; }

    // ======================== Windows ANSI enable (best-effort) =========================
    private static void maybeEnableAnsiOnWindows() {
        // For Windows 10+ CMD/PowerShell this is usually on; leaving no-op to keep single-file.
        // If colors don't show, enable "Use legacy console" OFF and "Virtual Terminal" ON in system settings,
        // or run from Windows Terminal.
    }
}
