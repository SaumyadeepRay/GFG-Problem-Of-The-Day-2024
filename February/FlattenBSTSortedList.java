// Flatten BST to sorted list

import java.util.ArrayList;
import java.util.List;

public class FlattenBSTSortedList {

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

    public static class BinaryTree {
        static int index = -1;

        public TreeNode buildTree(int[] nodes) {
            index = index + 1;
            if (nodes[index] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void inOrder(TreeNode root, List<Integer> in) {
        if (root != null) {
            inOrder(root.left, in);
            in.add(root.data);
            inOrder(root.right, in);
        }
    }

    public static TreeNode flattenBST(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);

        TreeNode head = new TreeNode(in.get(0));
        TreeNode p = head;

        // This code snippet creates a binary tree by iterating through a list of values
        // and assigning each value as the right child of the previous node in the tree.
        for (int i = 1; i < in.size(); i++) {
            p.right = new TreeNode(in.get(i));
            p.left = null;
            p = p.right;
        }

        print(head);

        return head;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 5, -1, 8, 7, -1, -1, 9, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println("Flatten BST to sorted list: ");
        flattenBST(root);
    }
}
