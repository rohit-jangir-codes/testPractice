package Practice;

import jdk.internal.classfile.components.ClassPrinter;

public class ReverseSortedList {

    public static void main(String[] args) {}

    public ClassPrinter.ListNode reverseList(ClassPrinter.ListNode node){
        ClassPrinter.ListNode prev = null, curr = node;

        while (curr != null){
            ClassPrinter.ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
