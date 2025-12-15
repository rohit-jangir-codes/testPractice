package Practice;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {}

    public class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public Test(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.next = head;
    }

    public void insert(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
    }

    public void remove(int key) {
        if(!map.containsKey(key)) return;

        Node node = map.get(key);
        Node next = node.next;
        Node prev = node.prev;
    }
}
