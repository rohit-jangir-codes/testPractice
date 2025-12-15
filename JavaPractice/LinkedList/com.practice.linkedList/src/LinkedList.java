public class LinkedList<T extends Comparable<T>>  implements List<T>{

    private Node<T> root;
    private int numberOfItems;
    @Override
    public void insert(T data) {
        if (root == null) {
            //first item in the linkedList
            root = new Node<>(data);
        } else {
            // we know that, this is not the first item
            insertBeginning(data);
        }
    }

    @Override
    public void remove(T data) {

        if (root == null) {
            return;
        }
        // to remove the first node
        if (root.getData().equals(data)) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {

        //We have to find the node we want to remove
        while (actualNode != null) {
            if (actualNode.getData().equals(data)) {
                numberOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
        }
        previousNode = actualNode;
        actualNode = actualNode.getNextNode();
    }

    @Override
    public void traverse() {
        if (root != null) {
            return;
        }
        Node<T> current = root;
        while (current != null) {
            System.out.println(root);
            current = current.getNextNode();
        }
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    // to update the refrence O(1)
    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    // we to start with the root node
    //first we find the last node O(N)
    private void insertEnd(T data, Node<T> node) {
// this is when we keep looking for the last node
        if (node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else  {
            // we found the last node
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }


    }
}
