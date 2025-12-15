import java.util.HashMap;
import java.util.Map;

public class LongestSubStringOfString {
    public static void main(String[] args) {
        LongestSubStringOfString longestSubStringOfString = new LongestSubStringOfString();
        System.out.println("Longest Substring of String abcabcbb is : " + longestSubStringOfString.longestSubstring("abcabcbb"));
    }

    public int longestSubstring(String s){
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(lastIndex.containsKey(c) && lastIndex.get(c) >= left){
                left = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
