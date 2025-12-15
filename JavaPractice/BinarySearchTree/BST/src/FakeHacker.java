import java.util.Random;

public class FakeHacker {
    private static final String GREEN = "\u001B[32m"; // ANSI green
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] fakeMessages = {
                "[+] Connecting to target server...",
                "[+] Bypassing firewall...",
                "[+] Exploiting port 22...",
                "[+] Uploading payload...",
                "[+] Establishing reverse shell...",
                "[+] Access granted! Root privileges obtained.",
                "[+] Extracting database...",
                "[+] Downloading credentials...",
                "[+] Encryption bypass successful.",
                "[+] Server compromised. Mission accomplished."
        };

        while (true) {
            // Random "matrix" style characters
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 80; i++) {
                char c = (char) (random.nextInt(94) + 33); // printable chars
                line.append(c).append(" ");
            }
            System.out.println(GREEN + line + RESET);

            // Occasionally print a fake hacking message
            if (random.nextInt(10) == 0) {
                String msg = fakeMessages[random.nextInt(fakeMessages.length)];
                System.out.println(GREEN + msg + RESET);
            }

            Thread.sleep(100); // slow down output
        }
    }
}
