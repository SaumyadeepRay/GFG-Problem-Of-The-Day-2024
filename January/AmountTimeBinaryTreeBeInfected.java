// Amount of Time for Binary Tree to Be Infected

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmountTimeBinaryTreeBeInfected {

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

    static Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public static int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        int time = -1;

        while (!queue.isEmpty()) {
            time++;
            for (int i = queue.size(); i > 0; i--) {
                int currentNode = queue.pollFirst();
                visited.add(currentNode);

                if (adjacencyList.containsKey(currentNode)) {
                    for (int neighbor : adjacencyList.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time;
    }

    private static void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            adjacencyList.computeIfAbsent(node.data, k -> new ArrayList<>()).add(node.left.data);
            adjacencyList.computeIfAbsent(node.left.data, k -> new ArrayList<>()).add(node.data);
        }

        if (node.right != null) {
            adjacencyList.computeIfAbsent(node.data, k -> new ArrayList<>()).add(node.right.data);
            adjacencyList.computeIfAbsent(node.right.data, k -> new ArrayList<>()).add(node.data);
        }

        convertToGraph(node.left);
        convertToGraph(node.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 5, -1, 4, 9, -1, -1, 2, -1, -1, 3, 10, -1, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.BuildTree(nodes);
        int start = 3;
        System.out.println("Amount of Time for Binary Tree to Be Infected: " + amountOfTime(root, start));
    }
}
