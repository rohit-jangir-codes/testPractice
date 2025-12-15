public class PalindromProblem {
    public static void main(String[] args) {

        PalindromProblem pp = new PalindromProblem();
        System.out.println(pp.solve("rohit"));
    }
    public boolean solve(String s) {

        // define 2 pointers (forward pointer and backward pointer and compare characters accordingly)

        String s1 = s;
        // eg madam
        char[] arr = s1.toCharArray();
        int last = arr.length - 1;
        int first = 0;
        while (first < last) {
            swap(arr, first, last);
            first++;
            last--;
        }
        char[] arr1 = s.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
    private void swap (char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean solve2(String s) {

        // time complexity O(N)
        int forward = 0;
        int backward = s.length() - 1;

        while (forward < backward) {
            if (s.charAt(forward) != s.charAt(backward)) {
                return false;
            }
            forward++;
            backward--;
        }
        return true;
    }
}