package Practice;

/*Problem
Given array nums, return the length of the longest consecutive elements sequence. Must
run in O(n).
What’s being tested?
        • HashSet lookups
• O(n) reasoning
• Detecting sequence "starts"
Optimal Approach (HashSet)
A number begins a sequence only if num - 1 is not present. Expand forward: num + 1, num +
        2, ...
Algorithm
1. Insert all numbers into a HashSet.
        2. For each number:
o If num - 1 not in set → start new sequence
o Expand: count length until numbers stop
3. Track max length.*/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNumbers {

    public static void main(String[] args) {

        LongestConsecutiveNumbers  longestConsecutiveNumbers = new LongestConsecutiveNumbers();

        System.out.println("The longest consecutive number is : "+longestConsecutiveNumbers.longestConsecutive(new int[] {100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
