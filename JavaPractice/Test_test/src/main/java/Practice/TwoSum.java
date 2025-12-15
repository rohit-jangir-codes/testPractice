package Practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        TwoSum ts = new TwoSum();
        int[] arr = ts.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int comp =  target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
