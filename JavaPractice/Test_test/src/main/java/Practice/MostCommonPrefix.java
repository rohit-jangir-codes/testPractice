package Practice;


/*Problem statement
Given an array of strings, find the longest common prefix among them. If there is none,
return "".
What interviewer tests
        String comparisons, edge/corner case handling. Multiple approaches: vertical scanning,
        horizontal scanning, divide-and-conquer, binary search.
Approach (simple & efficient)
Horizontal scanning: start with prefix = first string; for each next string, shrink prefix while
it’s not a prefix of that string (indexOf or startsWith).
Algorithm (step-by-step)
• If array empty return ""
        • prefix = strs[0]
        • For each i from 1..n-1:
o while (!strs[i].startsWith(prefix)) prefix = prefix.substring(0, prefix.length()-1)
o if prefix becomes empty return ""
        • Return prefix*/

public class MostCommonPrefix {

    public static void main(String[] args) {
        MostCommonPrefix obj = new MostCommonPrefix();
        System.out.println("most common prefix in [\"flower\",\"flow\",\"flight\"] is : "+ obj.longestCommonPrefix(new String[]{"flower","flower","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }

        return prefix;
    }
}
