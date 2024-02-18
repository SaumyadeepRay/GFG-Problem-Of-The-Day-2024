// Sum of leaf nodes in BST

public class SumLeafNodesBST {

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

    public static TreeNode insertRec(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public static int sumOfLeafNodes(TreeNode root) {
        // Base Case
        if (root == null) {
            return 0;
        }

        // Finding leaf Node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // Traversing left and right sub-nodes
        int left = sumOfLeafNodes(root.left);
        int right = sumOfLeafNodes(root.right);

        // Returning sum of leaf nodes
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] arr = { 45 };
        for (int val : arr) {
            root = insertRec(root, val);
        }
        System.out.println("Sum of leaf nodes in BST: " + sumOfLeafNodes(root));
    }
}
