public class Stack<T extends Comparable<T>> {
    private Node<T> head;
    private int count;

    // inserting takes O(1) time complexity
    public void push(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> oldHead = head;
            head = new Node<>(data);
            head.setNextNode(oldHead);
        }
        count ++;
    }
// LIFO, last in first out. with O(1)
    public T pop() {
        T item = head.getData();
        head = head.getNextNode();
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

}
