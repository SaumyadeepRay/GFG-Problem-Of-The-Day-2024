// Determine if Two Strings Are Close

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DetermineTwotringsAreClose {

    public static boolean closeStrings(String word1, String word2) {

        // Base case
        if (word1.length() != word2.length()) {
            return false;
        }

        // This code snippet creates a HashMap called "map1" and populates it with the
        // characters from a string called "word1" as keys and their frequencies as
        // values.
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // This code snippet creates a HashMap called "map2" and iterates through each
        // character in a string called "word2". It adds each character as a key in the
        // HashMap and increments its value by 1 if it already exists, or sets it
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // This code snippet checks if the key sets of two maps are equal. If they are
        // not equal, it returns false.
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // The code snippet creates two ArrayLists, "list1" and "list2", which contain
        // the values from two different maps, "map1" and "map2", respectively.
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());

        // This code snippet sorts two lists, list1 and list2, in ascending order using
        // the Collections.sort() method.
        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println("Determine if Two Strings Are Close: " + closeStrings(word1, word2));
    }
}
