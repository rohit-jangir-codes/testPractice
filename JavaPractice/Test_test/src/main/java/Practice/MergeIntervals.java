package Practice;
/*

Problem statement
Given array of intervals [[s1,e1], [s2,e2], ...], merge all overlapping intervals and return array
of merged intervals.
What interviewer tests
Sorting + merging intervals, edge case handling for contiguous/overlap boundaries.
Approach (optimal)
Sort intervals by start. Iterate and merge with last interval in result: if current.start <=
last.end -> merge last.end = max(last.end, current.end) else append new interval.
Algorithm (step-by-step)
• Sort intervals by start ascending.
• Initialize List<int[]> res = new ArrayList<>().
        • For each interval cur:
o if res empty or res.last.end < cur.start -> add cur
o else update res.last.end = max(res.last.end, cur.end)
• Return result converted to array.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        // Input intervals
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        // Call merge method
        int[][] result = m.merge(intervals);

        // Print result
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            }  else {
                list.add(current);
                current = next;
            }
        }
        list.add(current);
        return list.toArray(new int[list.size()][]);
    }
}
