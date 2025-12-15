package Practice;


/*Problem
Design a data structure that supports:
        • get(key)
• put(key, value)
All in O(1) time. When capacity exceeded → remove least recently used entry.
        What’s being tested?
        • HashMap + Doubly Linked List combination
• Ability to design data structures
• Understanding O(1) insert/delete in a list
• System design thinking at small scale
Optimal Approach
Use:
        • HashMap → key to Node
• Doubly Linked List → tracks usage (most recent at right end)
Operations:
        • get: move node to end
• put: insert/update node; if capacity reached → remove head
Diagram (mental model)
HEAD (LRU) ←→ ... ←→ TAIL (MRU)
Algorithm
1. For get(key):
o If not in map → return -1
o Move node to tail
o Return value
2. For put(key, value):
o If exists → update value, move to tail
o Else:
        ▪ Create new node, add to tail
▪ Add key in map
▪ If over capacity → remove head node and its key*/

import java.util.HashMap;
import java.util.Map;

public class LeastRecentUsedCache {

    public class Node {
        int value,key;
        Node next,prev;

        public Node(int value,int key){
            this.value=value;
            this.key=key;
        }
    }
    Map<Integer,Node> map;
    int capacity;
    private Node head;
    private Node tail;

    public LeastRecentUsedCache(int capacity){
        this.capacity=capacity;
        map=new HashMap<Integer,Node>();
        head=new Node(0,0);
        tail=new  Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key,int value){
        Node node=new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        map.put(key,node);
        insert(node);

        if (map.size()>capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }

    }

    public void insert(Node node){
        node.prev=tail.prev;
        node.next=tail;
        tail.prev.next=node;
        tail.prev=node;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
