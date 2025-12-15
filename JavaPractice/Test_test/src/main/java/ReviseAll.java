
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReviseAll {

    public static void main(String[] args) {}


    // Will find the sum of all the elements
    public int KadaneAlgorithm(int[] arr) {
        int current = arr[0];
        int best = arr[0];
       for (int i = 1; i < arr.length; i++) {
           current = Math.max(arr[i], current + arr[i]);
           best = Math.max(best, current);
       }

       return best;
    }

    // return longest subString from a string
    public int returnSubString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left) {
                left  = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left +1);
        }

        return max;
    }

    // Subarray Sum Equals K
    public int subArraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum -k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Top K Frequent Elements (Heap)

    public int[] returnFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i > 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }


    // Climbing Stairs (DP)
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int a = 1, b = 2;
        for(int i = 3; i <= n; i++){
            int c = a  + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Coin Change (DP)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
//        root.right = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // Diameter and Height of a tree
    int diameter = 0;
    public int returnDiameter(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l =  height(root.left);
        int r = height(root.right);

        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }

    // isStringPalindrome from a string. Can also be used to reverse a String
     public boolean isStringPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while  (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
     }

     public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
     }

     public int numberReverse(int n) {
        int remainder = 0, reversed = 0;
        while (n > 0) {
            remainder = n % 10;
            n = n / 10;
            reversed = reversed * 10 + remainder;
        }
        return reversed;
     }

     // Reverse a string
    public String revserseString(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        char[] arr2 = new char[n];
        for (int i = n-1; i >= 0; i--) {
            arr2[i] = arr[i];
        }

        return  String.valueOf(arr2);
    }

    // Selection sort
    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

}
