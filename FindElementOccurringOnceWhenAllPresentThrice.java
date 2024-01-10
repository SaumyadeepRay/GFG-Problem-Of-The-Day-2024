// Find element occurring once when all other are present thrice

import java.util.HashMap;

public class FindElementOccurringOnceWhenAllPresentThrice {

    public static int singleElement(int[] arr, int N) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 1, 1 };
        int N = 4;
        System.out.println("Find element occurring once when all other are present thrice: " + singleElement(arr, N));
    }
}
