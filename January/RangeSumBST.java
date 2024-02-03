// Range Sum of BST

public class RangeSumBST {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int index = -1;

        public TreeNode BuildTree(int[] nodes) {
            index = index + 1;
            if (nodes[index] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[index]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.data >= low && root.data <= high) {
            return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.data < low) {
            return rangeSumBST(root.right, low, high);
        }

        return rangeSumBST(root.left, low, high);
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 5, 3, -1, -1, 7, -1, -1, 15, -1, 18, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        int low = 7;
        int high = 15;
        System.out.println("Range Sum of BST: " + rangeSumBST(root, low, high));
    }
}