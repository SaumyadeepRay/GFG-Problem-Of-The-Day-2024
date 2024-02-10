// Number of Paths in a Matrix with K coins

public class NumberPathsInMatrixWithKCoins {

    public static long find(int n, int k, int[][] arr, int x, int y) {

        // This code snippet checks if either x or y is greater than or equal to n, or
        // if k is less than 0. If any of these conditions are true, it returns 0.
        if (x >= n || y >= n || k < 0) {
            return 0;
        }

        // This code snippet checks if the values of x and y are equal to n - 1, and if
        // the difference between k and arr[x][y] is equal to 0. If all conditions are
        // met, it returns 1.
        if (x == n - 1 && y == n - 1 && k - arr[x][y] == 0) {
            return 1;
        }

        // The code snippet assigns the result of a function call to the variable "a".
        // The function "find" takes in several parameters and returns a value based on
        // the values of those parameters.
        long a = find(n, k - arr[x][y], arr, x + 1, y);

        // The code snippet finds the value of 'b' by recursively calling the 'find'
        // function with updated parameters, including a modified value of 'k' and an
        // incremented value of 'y'.
        long b = find(n, k - arr[x][y], arr, x, y + 1);

        return a + b;
    }

    public static long numberOfPath(int n, int k, int[][] arr) {
        return find(n, k, arr, 0, 0);
    }

    public static void main(String[] args) {
        int k = 12;
        int n = 3;
        int[][] arr = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
        System.out.println("Number of Paths in a Matrix with K coins: " + numberOfPath(n, k, arr));
    }
}
