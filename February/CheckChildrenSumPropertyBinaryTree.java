// Check for Children Sum Property in a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class CheckChildrenSumPropertyBinaryTree {

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

    // Approach 1
    public static int isSumProperty1(TreeNode root) {
        // Base Case
        if (root == null) {
            return 1;
        }

        // This code snippet checks if both the left and right child of a given root
        // node are null. If they are, it returns 1.
        if (root.left == null && root.right == null) {
            return 1;
        }

        int childSum = 0;

        // This code snippet checks if the left child of a given root node exists, and
        // if so, it adds the value of the left child's data to a variable called
        // childSum.
        if (root.left != null) {
            childSum += root.left.data;
        }
        // This code snippet checks if the right child of a given node exists, and if
        // so, adds its data value to a variable called childSum.
        if (root.right != null) {
            childSum += root.right.data;
        }
        // This code snippet checks if the data value of the root node is equal to the
        // childSum. If it is not, it returns 0.
        if (root.data != childSum) {
            return 0;
        }

        // This code snippet checks if the left and right subtrees of a binary tree
        // satisfy the sum property, and returns the logical AND of the results.
        return isSumProperty1(root.left) & isSumProperty1(root.right);
    }

    // Approach 2
    public static int isSumProperty2(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = que.remove();

                // This code snippet checks if the "left" child of the current node is not null,
                // and if so, adds it to a queue called "que".
                if (current.left != null) {
                    que.add(current.left);
                }

                // This code snippet checks if the "right" child of the current node is not
                // null, and if so, adds it to a queue called "que".
                if (current.right != null) {
                    que.add(current.right);
                }

                // This code checks if both the left and right child of the current node are
                // null. If they are, it breaks out of the loop.
                if (current.left == null && current.right == null) {
                    break;
                }

                int left;
                int right;

                // This code snippet checks if the "left" child of the current node is not null.
                // If it is not null, it assigns the value of the "left" child's data to the
                // variable "left". Otherwise, it assigns the value 0
                if (current.left != null) {
                    left = current.left.data;
                } else {
                    left = 0;
                }

                // This code snippet checks if the right child of the current node is not null.
                // If it is not null, it assigns the value of the right child's data to the
                // variable "right". Otherwise, it assigns the value 0 to "right".
                if (current.right != null) {
                    right = current.right.data;
                } else {
                    right = 0;
                }

                // This code snippet checks if the value of current.data is equal to the sum of
                // left and right. If it is not, it returns 0.
                if (current.data != left + right) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nodes = { 35, 20, 15, -1, -1, 5, -1, -1, 15, 10, -1, -1, 5, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Check for Children Sum Property in a Binary Tree: " + isSumProperty1(root));
        System.out.println("Check for Children Sum Property in a Binary Tree: " + isSumProperty2(root));
    }
}
