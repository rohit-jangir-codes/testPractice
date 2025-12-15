import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {}

    public boolean isAnnagram(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int right = str.length() - 1;
        int left = 0;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }



    // int palindrome as well
    public int reverseANumber(int n) {
        int remainder = 0, reserved = 0;
        while (n > 0) {
            remainder = n % 10;
            reserved = reserved * 10 + remainder;
            n /= 10;
        }
        return reserved;
    }

    public void bubSort(int[] arr) {

    }


}
