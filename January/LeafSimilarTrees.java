// Leaf-Similar Trees

import java.util.ArrayList;

public class LeafSimilarTrees {

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

        public TreeNode BuildTree(int[] nums) {
            index = index + 1;
            if (nums[index] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nums[index]);
            newNode.left = BuildTree(nums);
            newNode.right = BuildTree(nums);
            return newNode;
        }

    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        traverseTree(list1, root1);
        ArrayList<Integer> list2 = new ArrayList<>();
        traverseTree(list2, root2);
        if (list1.equals(list2)) {
            return true;
        }
        return false;
    }

    public static void traverseTree(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.data);
        }
        traverseTree(list, root.left);
        traverseTree(list, root.right);
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 9, -1, -1, 8, -1, -1 };
        BinaryTree node1 = new BinaryTree();
        TreeNode root1 = node1.BuildTree(arr1);
        int[] arr2 = { 3, 5, 6, -1, -1, 7, -1, -1, 1, 4, -1, -1, 2, 9, -1, -1, 8, -1, -1 };
        BinaryTree node2 = new BinaryTree();
        TreeNode root2 = node2.BuildTree(arr2);
        System.out.println("Leaf-Similar Trees: " + leafSimilar(root1, root2));
    }
}
