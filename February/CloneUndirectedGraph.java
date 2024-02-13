// Clone an Undirected Graph

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CloneUndirectedGraph {

    class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        Node start = node;

        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> map = new HashMap<>();

        dfs(start, visited, map);

        addEdges(map);

        return map.get(start);
    }

    public static void addEdges(HashMap<Node, Node> map) {
        for (Map.Entry m : map.entrySet()) {
            Node ori = (Node) m.getKey();
            map.get(m.getKey()).neighbors.add(ori);
        }
    }

    public static void dfs(Node start, HashSet<Node> visited, HashMap<Node, Node> map) {
        visited.add(start);
        Node copyNode = new Node(start.val);
        map.put(start, copyNode);
        for (Node p : start.neighbors) {
            if (!visited.contains(p)) {
                dfs(p, visited, map);
            }
        }
    }
}
