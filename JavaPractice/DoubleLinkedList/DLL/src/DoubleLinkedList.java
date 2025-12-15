public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void reverse(){

        Node<T> currentNode = this.head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while (currentNode != null){
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.head = previousNode;
    }

    public void insert(T data) {

        Node<T> newNode = new Node<>(data);
        //this is the first item in the LL
        if (tail == null) {
            //both of the pointers are pointing to the new node
            tail = newNode;
            head = newNode;
        } else {
            //inserting at the end of the LL
            // manipulate the references at the end/ tail with O(1)
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;

        }
    }

    // traverse the LL in forward manner

    public  void traverseForward() {
        Node<T> actualNode = head;

        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNext();
        }
    }

    // traverse in backward
    public  void traverseBackward() {
        Node<T> actualNode = tail;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getPrev();
        }
    }
}
