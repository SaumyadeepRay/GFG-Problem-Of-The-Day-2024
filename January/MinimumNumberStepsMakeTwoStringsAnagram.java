// Minimum Number of Steps to Make Two Strings Anagram

import java.util.HashMap;

public class MinimumNumberStepsMakeTwoStringsAnagram {

    // Approach 1 (Using HashMap)
    public static int minSteps1(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int steps = 0;

        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                steps++;
            }
        }

        return steps;
    }

    // Approach 2 (Using Array)
    public static int minSteps2(String s, String t) {
        int[] characters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 'a'] = characters[s.charAt(i) - 'a'] + 1;
            characters[t.charAt(i) - 'a'] = characters[t.charAt(i) - 'a'] - 1;
        }

        int result = 0;

        for (int val : characters) {
            if (val > 0) {
                result = result + val;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String t = "practice";
        System.out.println("Minimum Number of Steps to Make Two Strings Anagram: " + minSteps1(s, t));
        System.out.println("Minimum Number of Steps to Make Two Strings Anagram: " + minSteps2(s, t));
    }
}
