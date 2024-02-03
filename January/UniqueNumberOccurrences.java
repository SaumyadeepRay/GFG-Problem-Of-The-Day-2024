// Unique Number of Occurrences

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        // This code snippet iterates over an array called "arr" and counts the
        // frequency of each element in the array using a HashMap called "map".
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        // This code snippet iterates over the values in a map. If a value is not
        // already in a set, it adds it. If a value is already in the set, it returns
        // false.
        for (int val : map.values()) {
            if (!set.contains(val)) {
                set.add(val);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        System.out.println("Unique Number of Occurrences: " + uniqueOccurrences(arr));
    }
}
