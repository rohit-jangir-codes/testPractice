public class Heart {
    public static void main(String[] args) {
        for (int y = 15; y >= -15; y--) {
            StringBuilder line = new StringBuilder();
            for (int x = -30; x < 30; x++) {
                double xx = Math.pow(x * 0.04, 2);
                double yy = Math.pow(y * 0.1, 2);
                boolean inside = Math.pow(xx + yy - 1, 3) - xx * Math.pow(y * 0.1, 3) <= 0;
                line.append(inside ? "♥" : " ");
            }
            System.out.println(line);
        }
    }
}
