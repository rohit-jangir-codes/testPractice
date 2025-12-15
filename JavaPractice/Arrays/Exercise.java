public class Exercise {

    // this is the algorithm that reverses the input array (nums)
    public int[] solve(int[] nums) {

        // hint: define 2 pointers (pointing to the last and first item of the array) and make a single iteration ...
//        int index = nums[0];
//        int index = nums[nums.length-1];
//        int[] newArr = new int[nums.length];
//        int length = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            newArr[i] = nums[length -1 -i];
//        }

//        nums.re
        int index1 = 0;
        int index2 = nums.length - 1;
        while (index1 < index2) {
            swap(nums, index1, index2);
            index1++;
            index2--;
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    private reTry(){
        int[] arr = new int[10];

        int index1 = 0;
        int index2 = arr.length - 1;

    }



}