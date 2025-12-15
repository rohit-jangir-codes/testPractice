package Practice;
/*
Problem statement
Given array of strings, group anagrams together. Return list of groups.
What interviewer tests
Hashing with canonical keys (sorted string or letter counts). Handling string
transformations and grouping.
Approach (optimal)
Use Map<String, List<String>> where key is canonical form: either sorted characters of
string or 26-count encoding (for lowercase a-z). For general strings, sorted key is easiest.
Algorithm (step-by-step)
• For each string s:
o convert to char array, Arrays.sort(chars), key = new String(chars)
o map.computeIfAbsent(key, k -> new ArrayList<>()).add(s)
• return new ArrayList<>(map.values())*/

import java.util.*;

public class GroupAnnagram {

    public static void main(String[] args) {
        GroupAnnagram groupAnnagram = new GroupAnnagram();

        System.out.println("Group annagram");
        List<List<String>> result = groupAnnagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
