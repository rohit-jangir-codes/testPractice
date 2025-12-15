import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("Rohit");
        list.insert("Rohit1");
        list.insert("Rohit2");
        list.insert("Rohit3");

//        list.traverseBackward();
//        list.traverseForward();

        System.out.println(5/2);
        System.out.println(4/2);

        // Linked list in java
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Rohit");
        linkedList.add("Rohit1");
        linkedList.addFirst("Rohit2");
        linkedList.addLast("Rohit3");

        linkedList.removeFirst();
        linkedList.removeLast();

        for (String str : linkedList) {
            System.out.println(str);
        }

    }
}