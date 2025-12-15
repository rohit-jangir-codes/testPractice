import java.util.Stack;

public class QueueUsingSingleStack {

    private Stack<Integer> stack;

    public QueueUsingSingleStack() {
        stack = new Stack<>();
    }

    public void enqueue(int value) {
        stack.push(value);
    }

    public int dequeue() {
        if(stack.size()==1){
            return stack.pop();
        }
        int item = stack.pop();
        int lastDequeuedItem = dequeue();
        enqueue(item);
        return lastDequeuedItem;
    }
}
