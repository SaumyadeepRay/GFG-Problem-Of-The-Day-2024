// Pseudo-Palindromic Paths in a Binary Tree

public class PseudoPalindromicPathsBinaryTree {

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

    static int ans = 0;

    public static int pseudoPalindromicPaths(TreeNode root) {
        func(root, 0);
        return ans;
    }

    public static void func(TreeNode node, int seen) {

        // Base Case
        if (node == null) {
            return;
        }

        // This code snippet performs a bitwise XOR operation between the variable
        // "seen" and the result of shifting the value 1 to the left by the value of
        // "node.data".
        seen = seen ^ (1 << node.data);

        // This code checks if a node in a binary tree has no left or right child. If
        // so, it checks if a certain condition is met and increments a counter if it
        // is.
        if (node.left == null && node.right == null) {
            if ((seen & (seen - 1)) == 0) {
                ans++;
            }
            return;
        }
        func(node.left, seen);
        func(node.right, seen);
    }

    public static void main(String[] args) {
        int[] nodes = { 2, 3, 3, -1, -1, 1, -1, -1, 1, -1, 1, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Pseudo-Palindromic Paths in a Binary Tree: " + pseudoPalindromicPaths(root));
    }
}
