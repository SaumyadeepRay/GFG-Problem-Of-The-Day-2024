// Distribute Candies in a Binary Tree

public class DistributeCandiesInBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
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

    public static int solve(TreeNode root, int[] moves) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left, moves);
        int right = solve(root.right, moves);

        moves[0] += Math.abs(left) + Math.abs(right);

        return root.data + left + right - 1;
    }

    public static int distributeCandy(TreeNode root) {

        // but we will have to avoid ourself from the use of global variables.

        int[] ans = new int[1];

        solve(root, ans);

        return ans[0];
    }

    public static void main(String[] args) {
        int[] nodes = { 4, 2, 1, -1, -1, 3, -1, -1, 7, 6, -1, -1, 9, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Distribute candies in a binary tree: " + distributeCandy(root));
    }
}
