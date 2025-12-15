import java.util.Stack;

public class MaxInStackProblem {

    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public MaxInStackProblem() {
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        minStack.push(x);
        // only single item
        if(minStack.size() == 1) {
            maxStack.push(x);
            return;
        }

        // if the item is largest on so far
        if(x>maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        minStack.pop();
        return maxStack.pop();
    }

    public int getMaxItem() {
        return maxStack.peek();
    }
}
