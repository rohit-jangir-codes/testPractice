package Practice;

/*Problem statement
Given height[] of n vertical lines at x=0..n-1, find maximum area of water container formed
by two lines.
What interviewer tests
Two-pointer greedy: maximizing area by moving shorter pointer inward.
Approach (optimal)
Two pointers l=0, r=n-1. Compute area = min(height[l],height[r]) * (r-l). Move the pointer with
smaller height inward (because moving the taller one cannot increase min height). Keep
track of max.
Algorithm (step-by-step)
• l=0, r=n-1, maxArea=0
        • while l < r:
o area = Math.min(h[l],h[r])*(r-l)
o update maxArea
o if h[l] < h[r] l++ else r--*/

public class ContainerWithMostWater {
    public static void main(String args[]){
        ContainerWithMostWater obj = new ContainerWithMostWater();

        System.out.println("Container with most area is: "+ obj.containerWithWater(new int[] {7,1,5,3,6,4}));
        System.out.println("Container with most area is: "+ obj.containerWithWater(new int[] {1,8,6,2,5,4,8,3,7}));
    }
    public int containerWithWater(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            if (height[left] < height[right]){
                left++;
            } else  {
                right--;
            }
        }

        return max;
    }
}
