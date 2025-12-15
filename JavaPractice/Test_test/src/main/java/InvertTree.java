
public class InvertTree {
    public static void main(String[] args) {

        InvertTree test = new InvertTree();

        // Build example tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Before inversion: ");
        test.printTree(root);

        // Call invertTree
        TreeNode inverted = test.invertTree(root);

        System.out.println("\nAfter inversion: ");
        test.printTree(inverted);

        System.out.println("--------------------------------------------------------------- ");

        System.out.println("Diameter of the tree is : " + test.returnDiameter(root));

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

    public void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }

    int diameter = 0;
    public int returnDiameter(TreeNode root) {
        height(root);
        return diameter;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }
}
