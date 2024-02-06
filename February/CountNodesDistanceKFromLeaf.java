// Count the nodes at distance K from leaf

import java.util.ArrayDeque;
import java.util.Queue;

public class CountNodesDistanceKFromLeaf {

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

    // Function to return count of nodes at a given distance from leaf nodes.
    public static int printKDistantfromLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int c = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode current = q.remove();
                if (solve(current, k)) {
                    c++;
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return c;
    }

    public static boolean solve(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if ((root.left == null && root.right == null) && k == 0) {
            return true;
        }
        if ((root.left == null && root.right == null) || k <= 0) {
            return false;
        }

        boolean l = solve(root.left, k - 1);
        boolean r = solve(root.right, k - 1);
        return l || r;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, 8, -1, -1, 7, -1, -1 };
        int k = 2;
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Count the nodes at distance K from leaf: " + printKDistantfromLeaf(root, k));
    }
}
