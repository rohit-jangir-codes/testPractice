import java.util.Random;

public class HackerSimulator {
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        clearScreen();
        System.out.println(GREEN + "Initializing Hacker Console..." + RESET);
        Thread.sleep(2000);

        fakeProgress("Booting virtual machine", 50);
        fakeProgress("Establishing secure tunnel", 70);
        fakeProgress("Connecting to target server", 100);

        fakeHackSequence();

        System.out.println(GREEN + "\n[+] Simulation complete. Target system fully compromised." + RESET);
    }

    private static void fakeHackSequence() throws InterruptedException {
        String[] stages = {
                "Scanning open ports",
                "Fingerprinting server OS",
                "Launching dictionary attack",
                "Exploiting vulnerability CVE-2025-1337",
                "Injecting backdoor",
                "Downloading password hashes",
                "Cracking hashes with rainbow tables",
                "Escalating privileges",
                "Exfiltrating sensitive data",
                "Wiping logs to cover tracks"
        };

        for (String stage : stages) {
            fakeProgress(stage, 100);
            Thread.sleep(500);
            for (int i = 0; i < 5; i++) {
                printMatrixLine();
                Thread.sleep(100);
            }
        }
    }

    private static void fakeProgress(String task, int maxPercent) throws InterruptedException {
        System.out.print(GREEN + "[*] " + task + "..." + RESET);
        for (int i = 0; i <= maxPercent; i += random.nextInt(15) + 5) {
            System.out.print("\r" + GREEN + "[*] " + task + " [" + progressBar(i) + "] " + i + "%" + RESET);
            Thread.sleep(random.nextInt(200) + 100);
        }
        System.out.println();
    }

    private static String progressBar(int percent) {
        int totalBars = 30;
        int filled = (percent * totalBars) / 100;
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < totalBars; i++) {
            bar.append(i < filled ? "#" : ".");
        }
        return bar.toString();
    }

    private static void printMatrixLine() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            char c = (char) (random.nextInt(94) + 33); // random printable ASCII
            line.append(c).append(" ");
        }
        System.out.println(GREEN + line + RESET);
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
