// Does Array Represent Heap

public class DoesArrayRepresentHeap {

    public static boolean countSub(long arr[], long n) {
        // This algorithm checks if the given array represents a binary heap by
        // comparing parent nodes with their left and right child nodes. If a child node
        // is greater than its parent, it returns false.
        for (int i = 0; i < n; i++) {
            // left child index =2i+1
            // This checks if the element at index (2 * i) + 1 in the array is greater than
            // the element at index i, and returns false if it is.
            if (2 * i + 1 < n) {
                if (arr[(2 * i) + 1] > arr[i]) {
                    return false;
                }
            }
            // right child index =2i+2
            // Checks if the element at index (2 * i) + 2 in the array is greater than the
            // element at index i, and returns false if it is.
            if (2 * i + 2 < n) {
                if (arr[(2 * i) + 2] > arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 6;
        long[] arr = { 90, 15, 10, 7, 12, 2 };
        System.out.println("Does Array Represent Heap: " + countSub(arr, n));
    }
}
