// Minimum Number of Operations to Make Array Empty

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOperationsMakeArrayEmpty {

    public static int minOperations(int[] nums) {
        // Create a HashMap to store the frequency of each element in 'nums'
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element in 'nums'
        for (int num : nums) {
            // Put the element in the map and increment its count by 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Initialize a variable to count the minimum operations needed
        int count = 0;

        // Iterate through the entries in the HashMap
        for (int val : map.values()) {

            // If there is only one occurrence of any element, it's not possible to make it
            // divisible by 3
            if (val == 1) {
                return -1;
            }
            // Calculate the number of operations needed to make the frequency divisible by
            // 3
            count = count + val / 3; // Count the complete sets of 3 elements
            if (val % 3 != 0) { // If there are remaining elements, increment the count
                count++;
            }
        }

        // Return the total count of operations needed
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 2, 2, 4, 2, 3, 4 };
        System.out.println("Minimum Number of Operations to Make Array Empty: " + minOperations(nums));
    }
}
