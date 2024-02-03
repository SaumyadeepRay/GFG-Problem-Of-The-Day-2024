// Out of Boundary Paths

public class OutOfBoundaryPaths {

    static Integer dp[][][];
    static int mod = (int) 1e9 + 7;

    // This code snippet defines a method that takes in the dimensions of a grid,
    // the maximum number of moves allowed, and the starting position. It
    // initializes a 3D array and then calls another method to solve the problem.
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return solve(m, n, maxMove, startRow, startColumn);
    }

    // The code snippet is a recursive function that calculates the number of
    // possible paths in a grid of size m x n, starting from a given position (row,
    // col), and with a given number of moves. The function uses dynamic programming
    // to store and reuse
    public static int solve(int m, int n, int moves, int row, int col) {
        if (row >= m || col >= n || row < 0 || col < 0) {
            return 1;
        }
        if (moves <= 0) {
            return 0;
        }
        if (dp[row][col][moves] != null) {
            return dp[row][col][moves];
        }
        int ans = 0;
        ans = (ans + solve(m, n, moves - 1, row - 1, col)) % mod;
        ans = (ans + solve(m, n, moves - 1, row + 1, col)) % mod;
        ans = (ans + solve(m, n, moves - 1, row, col - 1)) % mod;
        ans = (ans + solve(m, n, moves - 1, row, col + 1)) % mod;
        return dp[row][col][moves] = ans;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRow = 0;
        int startColumn = 0;
        System.out.println("Out of Boundary Paths: " + findPaths(m, n, maxMove, startRow, startColumn));
    }
}
