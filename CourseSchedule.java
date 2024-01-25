// Course Schedule

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // create Graph
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            map.get(prerequisites.get(i).get(0)).add(prerequisites.get(i).get(1));
        }

        int index[] = new int[n];
        for (int i = 0; i < map.size(); i++) {
            for (Integer it : map.get(i)) {
                index[it]++;
            }
        }

        // BFS start
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 0) {
                q.add(i);
            }
        }
        int ans[] = new int[n];
        int count = 0;
        int cycle = 0;
        while (!q.isEmpty() && cycle < n) {
            cycle++;
            int val = q.poll();
            ans[count++] = val;
            for (Integer it : map.get(val)) {
                index[it]--;
                if (index[it] == 0) {
                    q.add(it);
                }
            }
        }
        // checking graph contain cycle or not.
        if (cycle < n) {// if cycle contain then {ordering not possible}
            int pos[] = {};
            return pos;
        }

        // return out according to the question.
        for (int i = 0; i < n / 2; i++) {
            int temp = ans[i];
            ans[i] = ans[n - i - 1];
            ans[n - i - 1] = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] num = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();

        // Iterate through the 2D array and add each inner array as a separate element
        // to the ArrayList
        for (int[] innerArray : num) {
            ArrayList<Integer> currentPrerequisite = new ArrayList<>();
            for (int element : innerArray) {
                currentPrerequisite.add(element);
            }
            prerequisites.add(currentPrerequisite);
        }
        
        System.out.println("Course Schedule: " + Arrays.toString(findOrder(n, m, prerequisites)));
    }
}
