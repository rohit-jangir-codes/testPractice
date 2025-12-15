import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tree<Integer> bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(2);
        bst.insert(5);
        bst.insert(8);
        bst.insert(9);
        bst.insert(60);
        bst.insert(70);
        bst.insert(80);
        bst.insert(19);
        bst.insert(-1);

        List<Integer> list = bst.traverse();

        Tree<Integer> bst1 = new BinarySearchTree();
        bst1.insert(10);
        bst1.insert(2);
        bst1.insert(5);
        bst1.insert(8);
        bst1.insert(9);
        bst1.insert(60);
        bst1.insert(70);
        bst1.insert(80);
        bst1.insert(19);
        bst1.insert(-1);

        CompareTree<Integer> ct = new CompareTree<>();
        System.out.println(" \n  Comparing by new method:-------->" + ct.isTreeSame(bst1.getRoot(), bst.getRoot()));

        List<Integer> list1 = bst1.traverse();
        boolean flag = true;

//        System.out.println("list 1 is" + list1 + "\n");
        if (list1.size() == list.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list.get(i))) {
                    flag = false;
                    break; // stop at first mismatch
                }
            }
        } else {
            flag = false; // sizes don’t match
        }


        if (flag) {
            System.out.println(" \n Both the BST are identical");
        } else {
            System.out.println("\n Both the BST are not identical");
        }


//        System.out.println(bst.getMin());
//        System.out.println(bst.getMax());
//        bst.traverse();

    }
}