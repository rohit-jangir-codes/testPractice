public class CompareTree<T extends Comparable<T>> {
    public boolean isTreeSame(Node<T> node1, Node<T> node2) {
        if ((node1 == null && node2 == null) ||
                (node1==null && node2 != null) ||
                (node1 != null && node2 == null)) {
            return node1 == node2;
        }

        if (node1.getData().compareTo(node2.getData()) != 0)
        {
            return false;
        }
        return isTreeSame(node1.getLeftChild(), node2.getLeftChild()) &&
                isTreeSame(node1.getRightChild(), node2.getRightChild());
    }
}
