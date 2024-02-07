// Min distance between two given nodes of a Binary Tree

public class MinDistanceBetweenTwoGivenNodesBinaryTree {

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

    public static int findDist(TreeNode root, int a, int b) {

        // Base Case
        if (root == null) {
            return -1;
        }

        // This code snippet finds the lowest common ancestor (LCA) of two nodes, "a"
        // and "b", in a binary tree with "root" as the starting point. The LCA is
        // stored in the variable "LCA".
        TreeNode LCA = FindLCA(root, a, b);

        // The code snippet calculates the height of two nodes, 'a' and 'b', in a tree
        // using the lowest common ancestor (LCA) as a reference.
        int h1 = height(LCA, a);
        int h2 = height(LCA, b);

        return h1 + h2;
    }

    // This code snippet finds the lowest common ancestor (LCA) of two nodes with
    // values a and b in a binary tree. It recursively searches for the LCA by
    // checking if the current node is null or if it matches either a or b. If
    public static TreeNode FindLCA(TreeNode root, int a, int b) {

        if (root == null || root.data == a || root.data == b) {
            return root;
        }

        TreeNode left = FindLCA(root.left, a, b);
        TreeNode right = FindLCA(root.right, a, b);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    // This code snippet calculates the height of a binary tree starting from a
    // given node (LCA) and a target value (k). It recursively checks the left and
    // right subtrees of the LCA node until it finds the target value or reaches the
    // end
    public static int height(TreeNode LCA, int k) {
        if (LCA == null) {
            return -1;
        }

        if (LCA.data == k) {
            return 0;
        }

        int left = height(LCA.left, k);
        int right = height(LCA.right, k);

        if (left == -1 && right == -1) {
            return -1;
        }

        else if (right == -1) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 11, 22, 44, -1, -1, 55, -1, -1, 33, 66, -1, -1, 77, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        int a = 77;
        int b = 22;
        System.out.println("Min distance between two given nodes of a Binary Tree: " + findDist(root, a, b));
    }
}
