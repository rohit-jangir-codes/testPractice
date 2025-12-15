import java.util.Stack;

public class QueuesUsingStacks {

    // we are implementing the queues behaviour using queues

    // To insert the elements
    private Stack<Integer> enqueueStack;
    //To remove the elements
    private Stack<Integer> dequeueStack;

    public QueuesUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    public boolean isEmpty() {
        return dequeueStack.isEmpty();
    }
}
