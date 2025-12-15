package Practice;

/*A number is happy if repeatedly replacing it by sum of squares of digits eventually becomes
1.
If it loops endlessly in a cycle → not happy.
What’s being tested?
        • HashSet to detect cycles
• Math digit operations
• Loop detection
Approach (HashSet Cycle Detection)
Compute next number; if you see a number already seen → cycle → false.
Algorithm
1. Create a HashSet.
2. While n != 1 and n not in set:
o add n
o compute next = sum of squares of digits
3. return n == 1.*/

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {

        HappyNumber h = new HappyNumber();
        System.out.println("is given number a happy number? "+ h.isHappyNumber(2));
    }

    public boolean isHappyNumber(int n) {

        Set<Integer> seen = new HashSet<>();
        while(n!=1 && !seen.contains(n))
        {
            seen.add(n);
            n = squareDigits(n);
        }

        return n==1;
    }

    public int squareDigits(int n)
    {
        int sum=0, digit=0;
        while (n>0) {
            digit=n%10;
            sum=sum+digit;
            n=n/10;
        }

        return sum;
    }
}
