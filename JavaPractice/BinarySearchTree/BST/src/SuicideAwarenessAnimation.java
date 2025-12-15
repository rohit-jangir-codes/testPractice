public class SuicideAwarenessAnimation {
    private static final String[] leftPose = {
            "        _________ ",
            "       |         |",
            "       |   FAN   |",
            "       |_________|",
            "          ||",
            "          ||",
            "         (o)",    // head
            "        / |",     // body tilted left
            "          |",
            "         / \\"    // legs
    };

    private static final String[] rightPose = {
            "        _________ ",
            "       |         |",
            "       |   FAN   |",
            "       |_________|",
            "          ||",
            "          ||",
            "         (o)",    // head
            "          | \\",   // body tilted right
            "          |",
            "         / \\"    // legs
    };

    private static final String[] messages = {
            "⚠️ If you ever feel this way: PLEASE seek help. Call 1800-599-0019 (India).",
            "💚 You are NOT alone. Support is available, talk to someone you trust.",
            "☎️ Reach out now: Your life is valuable. Help is just a call away.",
            "🌱 Recovery is possible. One step at a time, with support.",
            "🤝 Together we can prevent suicide. Don’t suffer in silence."
    };

    public static void main(String[] args) throws InterruptedException {
        int msgIndex = 0;

        while (true) {
            clear();
            printPose(leftPose);
            System.out.println();
            System.out.println(messages[msgIndex % messages.length]);
            Thread.sleep(700);

            clear();
            printPose(rightPose);
            System.out.println();
            System.out.println(messages[(msgIndex + 1) % messages.length]);
            Thread.sleep(700);

            msgIndex++;
        }
    }

    private static void printPose(String[] pose) {
        for (String line : pose) {
            System.out.println(line);
        }
    }

    // Console clear (works in CMD and Unix terminals)
    private static void clear() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ignored) {}
    }
}
