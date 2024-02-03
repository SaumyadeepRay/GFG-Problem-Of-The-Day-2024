// Number of Submatrices That Sum to Target

import java.util.HashMap;

public class NumberSubmatricesThatSumTarget {

    public static int numSubmatrixSumTarget(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        
        // This code snippet iterates through a 2D array and adds the value of the
        // previous element in each row to the current element, effectively calculating
        // the cumulative sum for each row.
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        int count = 0;
        
        // This code snippet calculates the number of subarrays in a given array that
        // sum up to a target value. It uses nested loops and a HashMap to keep track of
        // the cumulative sum of subarrays and count the number of occurrences of the
        // target sum.
        for (int i = 0; i < n; i++) {
        
            // This code snippet calculates the number of subarrays in a given array that
            // sum up to a target value. It uses a hashmap to keep track of the cumulative
            // sum of subarrays and counts the number of occurrences of the target sum.
            for (int j = i; j < n; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                
                // This code snippet calculates the sum of elements in a 2D array column-wise,
                // subtracts a previous sum if applicable, and counts the number of times the
                // target sum is reached.
                for (int k = 0; k < m; k++) {
                    sum += arr[k][j] - (i > 0 ? arr[k][i - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
