// Paths From Root with a Specified Sum

import java.util.ArrayList;

public class PathsFromRootSpecifiedSum {

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

    public static void solve(TreeNode root, int s, int sum, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }
        s += root.data;
        al.add(root.data);
        if (sum == s) {
            ans.add(new ArrayList<>(al));
        }
        solve(root.left, s, sum, al, ans);
        solve(root.right, s, sum, al, ans);
        al.remove(al.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> printPaths(TreeNode root, int sum) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(root, 0, sum, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int sum = 8;
        int[] nodes = { 1, 20, -1, -1, 3, 4, 6, -1, -1, 7, -1, -1, 15, 8, -1, -1, 9, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Distribute candies in a binary tree: " + printPaths(root, sum));
    }
}
