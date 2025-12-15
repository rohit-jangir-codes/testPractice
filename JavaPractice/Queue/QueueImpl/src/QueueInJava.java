import java.util.LinkedList;
import java.util.Queue;

public class QueueInJava {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // to add the elements with O(1)
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // returns the element wihout removing it. O(1)
        System.out.println(queue.element());

        // O(1)
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
