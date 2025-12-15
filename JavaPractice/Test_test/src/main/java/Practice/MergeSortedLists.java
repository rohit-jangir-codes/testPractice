package Practice;

/*Problem
Given two sorted linked lists, merge them into one sorted list.
What’s being tested?
        • Linked-list construction
• Dummy node technique
• Handling null lists gracefully
Approach (Optimal)
Use a dummy head and pointer. Compare nodes from both lists and append smaller one.
        Algorithm
1. Create dummy node, tail = dummy.
2. While both lists not empty:
o append smaller node
o move pointer
3. Append remaining nodes
4. Return dummy.next*/

import jdk.internal.classfile.components.ClassPrinter;
import jdk.internal.classfile.impl.ClassPrinterImpl;

import java.util.HashMap;
import java.util.Map;

public class MergeSortedLists {

    public static void main(String[] args) {

    }

    public void merge(ClassPrinter.ListNode l1, ClassPrinter.ListNode l2) {
        ClassPrinter.ListNode dummy = new ClassPrinterImpl.ListNodeImpl(0);
        ClassPrinter.ListNode tail = dummy;

        while(l1!=null&&l2!=null){
            if(l1<l2){
                tail.next = l1;
                l1 = l1.next;

            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = (l1!=null) ? l1 :l2;

        return dummy.next;


    }

    public int[] returnIndices(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];

            if(map.containsKey(comp)){
                return new int[]{i,map.get(comp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
