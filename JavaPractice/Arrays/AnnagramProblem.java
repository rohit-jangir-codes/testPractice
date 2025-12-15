import java.util.Arrays;

public class AnnagramProblem {

    public static void main(String[] args) {

        AnnagramProblem ann = new AnnagramProblem();
        System.out.println(ann.solve("rohit".toCharArray(), "hitro".toCharArray())); // true
        System.out.println(ann.solve("rohit".toCharArray(), "test".toCharArray())); // false
   }
   private boolean solve(char[] s1, char[] s2) {
        if (s1.length != s2.length) {
            return false;
        }
        //sort the letters
       // it cause the bottleneck, cause of the sorting. It will result in the O(NlogN) time complexity

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        // the overall time complexity is O(NlogN)
        return true;
   }


}
