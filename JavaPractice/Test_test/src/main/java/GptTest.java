import java.util.HashMap;
import java.util.Map;

public class GptTest {

    public static void main(String[] args) {

        GptTest gptTest = new GptTest();
//        System.out.println("1. maximum subArray : " + gptTest.maximumSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println("2. longest Sub String : " + gptTest.longestSubString("abcabcbb"));
    }


    // 1. aximum Subarray (Medium)

    public int maximumSubArray(int[] nums) {
        int best = 0, current = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }

        return best;
    }

    //2. Longest subString without repeating characters
    public int longestSubString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char  c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
