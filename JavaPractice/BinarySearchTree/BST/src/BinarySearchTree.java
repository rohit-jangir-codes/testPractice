import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    List<T> storeArray = new ArrayList<>();

    @Override
    public T getMin() {
        // your implementation here !!! (you may have to define helper methods if needed)
        if(root == null)
        {
            return null;
        }

        return getMin(root);
    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() == null) {
            return node.getData();
        }
        return getMax(node.getRightChild());
    }

    private T getMin(Node<T> node) {
        // traverse left until no more left child
        if (node.getLeftChild() == null) {
            return node.getData();
        }
        return getMin(node.getLeftChild());
    }

    @Override
    public void insert(T data) {
        // this is when we insert the first node into the BST (parent is null)
        if(root==null) {
            root = new Node<>(data, null);
        } else {
            // there are already items in the BST
            insert(data, root);
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void search(T data) {

    }

    @Override
    public  List<T> traverse() {

//        System.out.println("invoking traverse");
//        System.out.println(root);

        if (root == null) {
//            System.out.println("entering if");
            return null;
        }
        return traverse(root);
    }

    private List<T> traverse(Node<T> node) {

//        System.out.println("invoking traverse 1");
        if (node.getLeftChild() != null) {
            traverse(node.getLeftChild());
        }
        System.out.print(node);
//        List<T> storeArray = new ArrayList<>();
        storeArray.add(node.getData());
//        System.out.print(node + "---------------------------------------");

        if (node.getRightChild() != null) {
            traverse(node.getRightChild());
        }
//        System.out.print(node + "-");
//        System.out.print(node + "---------------------------------------");

        return storeArray;
    }

    private void insert(T data, Node<T> node) {


        // this is the case when the data is SMALLER than the value in the node
        // GO TO THE LEFT SUBTREE
        if(node.getData().compareTo(data) > 0) {
            // there is a valid (not NULL) left child so we go there
            if( node.getLeftChild() != null )
                insert(data, node.getLeftChild());
                // the left child is a NULL so we create a left child
            else
                node.setLeftChild(new Node<>(data, node));
            // this is the case when the data is GREATER than the value in the node
            // GO TO THE RIGHT SUBTREE
        } else {
            // there is a valid (not NULL) right child so we go there
            if( node.getRightChild() != null )
                insert(data, node.getRightChild());
                // the right child is a NULL so we create a right child
            else
                node.setRightChild(new Node<>(data, node));
        }
    }


//
//    public boolean isTreeSame(Node<T> node1, Node<T> node2) {
//        if ((node1 == null && node2 == null) ||
//                (node1==null && node2 != null) ||
//                (node1 != null && node2 == null)) {
//            return node1 == node2;
//        }
//
//        if (node1.getData().compareTo(node2.getData()) != 0)
//        {
//            return false;
//        }
//            return isTreeSame(node1.getLeftChild(), node2.getLeftChild()) &&
//                    isTreeSame(node1.getRightChild(), node2.getRightChild());
//    }
}




/*public class Exercise<T extends Comparable<T>> {

    public boolean isTreeSame(Node<T> node1, Node<T> node2) {

	    // we have access to the root nodes (node1 and node2) of the binary search trees
		// your algorithm here !!!
	}
}

class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {

		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}
	}

	@Override
	public T getMaxValue() {

		if (root == null)
			return null;

		return getMax(root);
	}

	@Override
	public T getMinValue() {

		if (root == null)
			return null;

		return getMin(root);
	}

	@Override
	public void traversal() {
		if (root != null) {
			inOrderTraversal(root);
		}
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftChild() != null)
			inOrderTraversal(node.getLeftChild());

		System.out.print(node + "  -->  ");

		if (node.getRightChild() != null)
			inOrderTraversal(node.getRightChild());

	}

	private Node<T> delete(Node<T> node, T data) {


		if( node == null ) return node;

		if( data.compareTo(node.getData()) < 0 ) {
			node.setLeftChild( delete(node.getLeftChild(), data) );
		} else if ( data.compareTo(node.getData()) > 0 ) {
			node.setRightChild( delete(node.getRightChild(), data) );
		} else {

			// we have found the node we want to remove !!!
			if( node.getLeftChild() == null && node.getRightChild() == null ) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if( node.getLeftChild() == null ) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			} else if( node.getRightChild() == null ) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node<T> tempNode = getPredecessor(node.getLeftChild());

			node.setData(tempNode.getData());
			node.setLeftChild( delete(node.getLeftChild(), tempNode.getData()) );

		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {

		if( node.getRightChild() != null )
			return getPredecessor(node.getRightChild());

		System.out.println("Predecessor is: "+node);
		return node;
	}

	private void insertNode(T newData, Node<T> node) {

		if (newData.compareTo(node.getData()) < 0) {
			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		} else {
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
	}

	private T getMax(Node<T> node) {

		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}

		return node.getData();
	}

	private T getMin(Node<T> node) {

		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}

		return node.getData();
	}

	@Override
	public void delete(T data) {

		if (root != null)
			root = delete(root, data);
	}

	@Override
	public Node<T> getRoot() {
		return root;
	}

}

class Node<T> {

	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}

interface Tree<T> {
	public Node<T> getRoot();
	public void traversal();
	public void insert(T data);
	public void delete(T data);
	public T getMaxValue();
	public T getMinValue();
}*/
