// Sum of Subarray Minimums

public class SumSubarrayMinimums {

    static int mod = (int) 1e9 + 7;

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length + 1;
        int[] left = new int[n];
        int[] ext = new int[n];
        int[] sums = new int[n];
        for (int i = 0; i < n - 1; ++i)
            ext[i + 1] = arr[i];

        int res = 0;
        for (int i = 1; i < n; i++) {
            int cur = ext[i];
            int l = i - 1;
            while (ext[l] >= cur)
                l = left[l];

            left[i] = l;
            sums[i] = sums[l] + cur * (i - l);
            res = (res + sums[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println("Sum of Subarray Minimums: " + sumSubarrayMins(arr));
    }
}
