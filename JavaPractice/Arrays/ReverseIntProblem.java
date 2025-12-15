public class ReverseIntProblem {
    public  static void main(String[] args) {
      ReverseIntProblem obj = new ReverseIntProblem();
      System.out.println(obj.reverse(12345));
    }

    public int reverse(int x) {

        // time complexity O(N)
       int reversed = 0;
       int remainder = 0;
      while (x > 0) {
          remainder = x % 10;
          reversed = reversed * 10 + remainder;
          x /= 10;
      }
      return reversed;
    }
}