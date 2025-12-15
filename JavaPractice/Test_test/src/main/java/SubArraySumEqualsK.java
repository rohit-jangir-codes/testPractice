import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        System.out.println("Number of sub array in the arras [1,1,1] is : "+ subArraySumEqualsK.returnSubArraySum(new int[]{1,1,1}, 2));
    }

    public int returnSubArraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        for (int n : nums) {
            sum += n;
            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
