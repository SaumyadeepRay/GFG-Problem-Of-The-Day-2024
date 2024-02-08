// Check If All Leaves Are At Same Level

import java.util.LinkedList;
import java.util.Queue;

public class CheckAllLeavesAreSameLevel {

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

    public static boolean check(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (que.size() != 0) {
            int n = que.size();
            int nodeNull = 0;
            int nodeCount = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                // This code snippet checks if a given node has no left child and no right
                // child, and increments a counter if this condition is true.
                if (node.left == null && node.right == null) {
                    nodeNull++;
                }
                // If the left child of a node exists but the right child does not, add the left
                // child to a queue and increment a counter for the number of nodes.
                else if (node.left != null && node.right == null) {
                    que.add(node.left);
                    nodeCount++;
                }
                // This code snippet checks if a node has a left child but no right child. If
                // this condition is true, it adds the right child to a queue and increments a
                // counter.
                else if (node.left == null && node.right != null) {
                    que.add(node.right);
                    nodeCount++;
                }
                // This code snippet adds the left and right child nodes of a given node to a
                // queue and increments a counter if the node is not null.
                else {
                    que.add(node.left);
                    que.add(node.right);
                    nodeCount++;
                }
            }
            if (nodeNull > 0 && nodeCount > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 10, -1, -1, 15, -1, -1, 30, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        System.out.println("Check if all leaves are at same level: " + check(root));
    }
}
