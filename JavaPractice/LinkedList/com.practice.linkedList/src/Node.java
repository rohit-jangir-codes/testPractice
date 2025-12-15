

public class Node<T extends Comparable<T>> {
    //data that we store in the DS
    private T data;
    // reason for consuming the more memory
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @java.lang.Override
    public java.lang.String toString() {
//        return "Node{" +
//                "data=" + data +
//                "}->";
        return "" + data;
    }

//    public static void main(String args[]) {
//
//    }
}