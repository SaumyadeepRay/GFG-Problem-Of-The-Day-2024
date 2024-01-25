// Check If a Given Graph is Tree Or Not

import java.util.ArrayList;

public class CheckIfGivenGraphTreeOrNot {

    public static void dfs(int s, ArrayList<Integer>[] adj1, boolean[] vis) {
        vis[s] = true;
        for (int x : adj1[s]) {
            if (!vis[x]) {
                dfs(x, adj1, vis);
            }
        }
    }

    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // checked: number of vertices should be equal to (number of nodes -1) V=(N-1)
        // There should not be any disconnected node
        if ((n - m) != 1) {
            return false;
        }

        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] adj1 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj1[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> edge : edges) {
            adj1[edge.get(0)].add(edge.get(1));
            adj1[edge.get(1)].add(edge.get(0));
        }

        dfs(0, adj1, vis);

        for (boolean x : vis) {
            if (!x) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int[][] num = { { 0, 1 }, { 1, 2 }, { 1, 3 } };

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        // Iterate through the 2D array and add each inner array as a separate element
        // to the ArrayList
        for (int[] innerArray : num) {
            ArrayList<Integer> currentEdges = new ArrayList<>();
            for (int element : innerArray) {
                currentEdges.add(element);
            }
            edges.add(currentEdges);
        }

        System.out.println("Check If a Given Graph is Tree Or Not: " + isTree(N, M, edges));
    }
}
