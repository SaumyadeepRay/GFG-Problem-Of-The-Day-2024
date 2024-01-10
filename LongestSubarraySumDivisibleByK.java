// Longest subarray with sum divisible by K

import java.util.HashMap;

public class LongestSubarraySumDivisibleByK {

    public static int longSubarrWthSumDivByK(int arr[], int n, int k) {
        // Complete the function
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int rem = 0;

        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            rem = sum % k;

            // This code snippet checks if the value of "rem" is less than 0, and if so,
            // adds the value of "k" to it.
            if (rem < 0) {
                rem = rem + k;
            }

            // This code checks if a map contains a specific key. If it does, it calculates
            // the length between the current index and the frequency of the key, and
            // updates the answer variable if the length is greater.
            if (map.containsKey(rem)) {
                int freq = map.get(rem);
                int length = i - freq;
                if (length > answer) {
                    answer = length;
                }
            } else {
                map.put(rem, i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, 2, 2 };
        int n = 5;
        int k = 2;
        System.out.println("Longest subarray with sum divisible by K: " + longSubarrWthSumDivByK(arr, n, k));
    }
}
