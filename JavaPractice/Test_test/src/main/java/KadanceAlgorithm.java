public class KadanceAlgorithm {
    int[] nums = {1,2,3,4,5,6,7};
    int current = 0, best =0;

    public int returnSum (int[] nums) {
        int current = 0, best =0;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static void main(String[] args) {
        KadanceAlgorithm kadanceAlgorithm = new KadanceAlgorithm();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Result: "+ kadanceAlgorithm.returnSum(nums));

    }
}
