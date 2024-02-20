// Word Break

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        HashSet<String> set = new HashSet<>(dictionary);
        return helper(set, s) ? 1 : 0;
    }

    public static boolean helper(HashSet<String> set, String s) {
        // Base case
        if (s == null || s == "" || set.contains(s)) {
            return true;
        }

        // This code iterates through a string, splitting it into two parts at each
        // index. It checks if the first part is in a set and if the second part
        // satisfies a helper function, returning true if both conditions are met.
        for (int i = 1; i < s.length(); i++) {
            String part1 = s.substring(0, i);
            String part2 = s.substring(i);

            // Checks if a set contains a specific element "part1" and calls a helper
            // function with another element "part2". Returns true if both conditions are
            // met.
            if (set.contains(part1) && helper(set, part2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        String s = "ilike";
        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile" };
        ArrayList<String> dictionary = new ArrayList<>();
        for (String str : dict) {
            dictionary.add(str);
        }
        System.out.println("Word Break: " + wordBreak(n, s, dictionary));
    }
}
