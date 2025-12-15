public class StackArray<T> {
    private int count;
    private T[] stack;

    public StackArray() {
        stack = (T[]) new Object[1];
    }

    // add the new element at the end of the array
    public void push(T data) {
        // Array are not dynamic
        // we to resize the array when there are more element to insert
        // and resize or decrease when there are too less elements
        if (count == stack.length) {
            resize(2 * stack.length);
        }
        stack[count++] = data;
    }
    // return the last itme inserted with O(1)
    public T pop() {
        if (count == 0) {
            return null;
        }
        // We need to decrement the counter first cause
        // if there are 5 elements in the array thw indexes will be 0,1,2,3,4 but the count will point to 5
        T data = stack[--count];
        // Make the value as null to remove it by garbage collector
        stack[count] = null;
        if (count > 0 && count == stack.length / 4) {
            resize(stack.length / 2);
        }
        return data;
    }


    // This is the bottleneck of the app. It has O(N) running time complexity
    private void resize(int newSize) {
        T[] stackCopy = (T[]) new Object[newSize];

        for (int i = 0; i < count; i++) {
            stackCopy[i] = stack[i];
        }
        System.out.println("re-sizing the array............");
        stack = stackCopy;
    }

    //O(1)
    public boolean isEmpty() {
        return count == 0;
    }

}
