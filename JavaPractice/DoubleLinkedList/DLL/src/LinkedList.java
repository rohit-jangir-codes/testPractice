class LinkedList implements List {

    // this is the head node or root node
    private Node1 root;
    private int numOfItems;

    @Override
    public Node1 getMiddleNode() {

        if (root == null) {
            return null; // empty list
        }

        Node1 slow = root;
        Node1 fast = root;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow; // when fast reaches the end, slow is in the middle

//        if (root == null) {
//            return null; // empty list
//        }
//
//        // Compute the middle index
//        int midIndex;
//        if (numOfItems % 2 == 0) {
//            midIndex = (numOfItems / 2) + 1;  // upper middle for even-length list
//        } else {
//            midIndex = (numOfItems / 2) + 1;  // exact middle for odd-length list
//        }
//
//        // Traverse until the midIndex
//        Node1 current = root;
//        int count = 1;
//        while (count < midIndex) {
//            current = current.getNextNode();
//            count++;
//        }
//
//        return current;
    }

    public void reverse(){

    }

    @Override
    public void insert(int data) {

        if(root==null) {
            // this is the first item in the linked list
            root = new Node1(data);
        } else {
            // we know that this is not the first item in the linked list
            insertBeginning(data);
        }
    }

    // we just have to update the references O(1)
    private void insertBeginning(int data) {
        Node1 newNode = new Node1(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    // because we have to start with the root node
    // first we have to find the last node in O(N)
    private void insertEnd(int data, Node1 node) {

        // this is when we keep looking for the last node O(N)
        if(node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else {
            // we have found the last node
            Node1 newNode = new Node1(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void traverse() {

        if(root==null) return;

        Node1 actualNode = root;

        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }
}

interface List {
    public Node1 getMiddleNode();
    public void insert(int data);
    public void traverse();
    public int size();
}

class Node1 {

    private int data;
    private Node1 nextNode;

    public Node1(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node1 getNextNode() {
        return nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node1 nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}