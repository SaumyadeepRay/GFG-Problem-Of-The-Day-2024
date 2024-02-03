// Maximum Difference Between Node and Ancestor

public class MaximumDifferenceBetweenNodeAncestor {

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

    // Approach 1 (Brute Force Approach)

    static int maxValue = Integer.MIN_VALUE;

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);
        findMaxValue(root, root.data);
        return maxValue;
    }

    public static void findMaxValue(TreeNode root, int data) {
        if (root == null) {
            return;
        }
        maxValue = Math.max(maxValue, Math.abs(data - root.data));
        findMaxValue(root.left, data);
        findMaxValue(root.right, data);
    }

    // Approach 2 (Optimal Approach)

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static int maxAncestorDiffOptimal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return checkMAxValue(root, min, max);
    }

    public static int checkMAxValue(TreeNode root, int min, int max) {
        if (root == null) {
            return Math.abs(max - min);
        }

        min = Math.min(min, root.data);
        max = Math.max(max, root.data);

        int left = checkMAxValue(root.left, min, max);
        int right = checkMAxValue(root.right, min, max);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, -1, 2, -1, 0, 3, -1, -1, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Maximum Difference Between Node and Ancestor: " + maxAncestorDiff(root));
        System.out.println("Maximum Difference Between Node and Ancestor: " + maxAncestorDiffOptimal(root));
    }
}
