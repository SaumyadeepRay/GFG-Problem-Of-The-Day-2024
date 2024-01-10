// Array Pair Sum Divisibility Problem

import java.util.HashMap;

public class ArrayPairSumDivisibilityProblem {

    public static boolean canPair(int[] nums, int k) {
        int n = nums.length;

        // Base Case
        if (n % 2 != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int zeroRem = 0;

        for (int val : nums) {

            if (val % k == 0) {
                zeroRem++;
                continue;
            }

            int rem = val % k;
            int target = k - rem;

            // This code snippet checks if a map contains a specific target key. If it does,
            // it retrieves the frequency of that key from the map. If the frequency is 1,
            // the key is removed from the map. Otherwise, the frequency is decremented
            if (map.containsKey(target)) {
                int frequency = map.get(target);
                if (frequency == 1) {
                    map.remove(target);
                } else {
                    map.put(target, frequency - 1);
                }
            }
            
            // This code snippet adds the remainder (rem) to a map and increments its value
            // by 1 if it already exists in the map, otherwise it adds it to the map with a
            // value of 1.
            else {
                map.put(rem, map.getOrDefault(rem, 0) + 1);
            }
        }
        return map.size() == 0 && zeroRem % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 5, 7, 3 };
        int k = 6;
        System.out.println("Array Pair Sum Divisibility Problem: " + canPair(nums, k));
    }
}
