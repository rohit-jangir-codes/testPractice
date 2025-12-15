public class Queue<T extends Comparable<T>> {

    private Node<T> firsNode;
    private Node<T> lastNode;
    private int count;

    // O(1) constant
    // Always manipulate the last node for enqueue
    public void enqueue(T data) {
        Node<T> oldLastNode = lastNode;
        lastNode = new Node<>(data);
        if (isEmpty()) {
            firsNode = lastNode;
        } else {
            oldLastNode.setNextNode(lastNode);
        }
        count++;
    }

    // O(1) Constant
    // manipulate the first node
    public T dequeue() {
        if (isEmpty()) {
            lastNode = null;
            return null;
        }

        T temp = firsNode.getData();
        firsNode = firsNode.getNextNode();
        count--;
        return temp;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return firsNode == null;
    }
}
