public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs obj = new ClimbingStairs();
        System.out.println("ways to climb stairs are : "+obj.climbStairs(3));

    }

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
