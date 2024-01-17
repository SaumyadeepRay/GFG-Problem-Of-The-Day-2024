// All Unique Permutations of an array

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutationsOfArray {

    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Collections.sort(arr);
        check(arr, n, res, set, current, visited);
        return res;
    }

    public static void check(ArrayList<Integer> arr, int n, ArrayList<ArrayList<Integer>> res,
            Set<ArrayList<Integer>> set, ArrayList<Integer> current, boolean[] visited) {

        // This code checks if the size of the "current" list is equal to the size of
        // the "arr" list. If they are equal, it checks if the "current" list is not
        // already present in the "set". If it is not
        if (current.size() == arr.size()) {
            if (!set.contains(current)) {
                set.add(new ArrayList<>(current));
                res.add(new ArrayList<>(current));
            } else {
                return;
            }
        }

        // This code snippet iterates through a list of elements, checks if an element
        // has been visited, adds it to a current list, recursively checks the remaining
        // elements, and then removes the last element from the current list.
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            current.add(arr.get(i));
            check(arr, n, res, set, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
        int n = 3;
        System.out.println("All Unique Permutations of an array: " + uniquePerms(list, n));
    }
}
