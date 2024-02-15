// Count all Possible Path

public class CountPossiblePath {

    public static int isPossible(int[][] paths) {
        for (int i = 0; i < paths.length; i++) {
            int su = 0;
            // This code snippet counts the number of occurrences of the value 1 in the
            // array `paths[i]` and stores the count in the variable `su`.
            for (int j = 0; j < paths[i].length; j++) {
                // This code snippet checks if the value at index (i, j) in the "paths" array is
                // equal to 1, and if so, it increments the variable "su" by 1.
                if (paths[i][j] == 1) {
                    su++;
                }
            }
            // The code snippet checks if the variable "su" is odd. If it is, the code
            // returns 0.
            if (su % 2 == 1) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] paths = { { 0, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0, 1 },
                { 1, 0, 0, 1, 0 } };
        System.out.println("Count all Possible Path: " + isPossible(paths));
    }
}
