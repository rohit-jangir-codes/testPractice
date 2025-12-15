import java.util.List;

public interface Tree<T> {

    public void insert(T data);
    public void remove(T data);
    public void search(T data);
    //in-order traversal
    public List<T> traverse();
    public T getMin();
    public T getMax();
//    public boolean isTreeSame(Node<T> node1, Node<T> node2);

    public Node<T> getRoot();
}
