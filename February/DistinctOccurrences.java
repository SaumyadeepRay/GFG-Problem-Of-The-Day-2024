// Distinct Occurrences

import java.util.Arrays;

public class DistinctOccurrences {

    static int mod = (int) 1e9 + 7;
    static int dp[][] = null;

    public static int helper(String s, String t, int i, int j) {

        // This code checks if the variable `j` is equal to the length of the string
        // `t`, and if so, it returns the value 1.
        if (j == t.length()) {
            return 1;
        }

        // This code checks if the variable "i" is equal to the length of the string "s"
        // and returns 0 if they are equal.
        if (i == s.length()) {
            return 0;
        }

        // This snippet checks if a value in a 2D array is not equal to -1, and if so,
        // it returns that value.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int incl = 0;

        // This code checks if the characters at positions i in string s and j in string
        // t are equal, then calls a helper function with incremented positions i and j.
        if (s.charAt(i) == t.charAt(j)) {
            incl = helper(s, t, i + 1, j + 1);
        }

        int excl = helper(s, t, i + 1, j);

        // This line of code calculates the value to be stored in the dp array at index
        // i and j by summing the incl and excl variables and taking the result modulo
        // mod.
        return dp[i][j] = (incl + excl) % mod;
    }

    public static int subsequenceCount(String s, String t) {

        dp = new int[s.length()][t.length()];

        // This code initializes a 2D array `dp` with -1 in each element using a nested
        // enhanced for loop and `Arrays.fill()` method.
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }

        return helper(s, t, 0, 0);
    }

    public static void main(String[] args) {
        String s = "banana";
        String t = "ban";
        System.out.println("Distinct Occurrences: " + subsequenceCount(s, t));
    }
}
