// Maximum Length of a Concatenated String with Unique Characters

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthConcatenatedStringUniqueCharacters {

    public static int maxLength(List<String> arr) {
        int start = 0;
        int strLength = 0;
        int[] select = new int[26];
        return helper(start, arr, select, strLength);
    }

    public static int helper(int start, List<String> arr, int[] select, int strLength) {
        // Base case
        if (start == arr.size()) {
            return strLength;
        }
        String currentStr = arr.get(start);

        // This code snippet checks if the result of comparing the "select" variable
        // with the "currentStr" variable is false. If it is, it calls the "helper"
        // function with updated parameters.
        if (compare(select, currentStr) == false) {
            return helper(start + 1, arr, select, strLength);
        }

        // The code snippet recursively selects or deselects characters from a string,
        // and calculates the maximum length of selected characters. It returns the
        // maximum length among two options: selecting the current character or not
        // selecting it.
        else {
            
            // This code snippet iterates through each character in a string, subtracts the
            // ASCII value of 'a' from it, and sets the corresponding index in the "select"
            // array to 1.
            for (int i = 0; i < currentStr.length(); i++) {
                int ch = currentStr.charAt(i) - 'a';
                select[ch] = 1;
            }
            strLength = strLength + currentStr.length();
            int op1 = helper(start + 1, arr, select, strLength);
            
            // This code snippet iterates through each character in a string and sets the
            // corresponding index in an array to 0. The index is determined by subtracting
            // the character 'a' from the current character.
            for (int i = 0; i < currentStr.length(); i++) {
                int ch = currentStr.charAt(i) - 'a';
                select[ch] = 0;
            }
            strLength = strLength - currentStr.length();
            int op2 = helper(start + 1, arr, select, strLength);

            return Math.max(op1, op2);
        }
    }

    // This code snippet compares an array of integers and a string. It checks if
    // the characters in the string are unique and if they are not present in the
    // array. It returns true if both conditions are met, otherwise it returns
    // false.
    public static boolean compare(int[] select, String currentStr) {
        int[] temp = new int[26];

        // This code snippet checks if a string contains any duplicate characters by
        // using an array to keep track of the frequency of each character. If a
        // character is found to have a frequency of 1, it returns false.
        for (int i = 0; i < currentStr.length(); i++) {
            int ch = currentStr.charAt(i) - 'a';
            if (temp[ch] == 1) {
                return false;
            }
            temp[ch] = 1;
        }

        // This code snippet checks if any character in the string "currentStr" has
        // already been selected by checking the corresponding index in the "select"
        // array. If a character has already been selected, the code returns false.
        for (int i = 0; i < currentStr.length(); i++) {
            int ch = currentStr.charAt(i) - 'a';
            if (select[ch] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = { "un", "iq", "ue" };
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            list.add(str);
        }
        System.out.println("Maximum Length of a Concatenated String with Unique Characters: " + maxLength(list));
    }
}
