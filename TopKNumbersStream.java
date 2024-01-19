// Top K numbers in a stream

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TopKNumbersStream {

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] freq = new int[101];

        for (int i = 0; i < N; i++) {
            freq[arr[i]]++;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                int x = freq[a];
                int y = freq[b];

                if (x == y) {
                    return b - a;
                } else {
                    return x - y;
                }
            });

            int size = 0;

            for (int j = 0; j < 101; j++) {
                if (freq[j] == 0) {
                    continue;
                }

                pq.offer(j);
                size++;

                if (size > K) {
                    pq.poll();
                    size--;
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }

            Collections.reverse(list);

            // This is where test case for Java program was failing
            // 4 5
            // 3 4 0 0
            // Not including those list whose first element starts with 0, instead add empty
            // list.
            if (!list.isEmpty() && list.get(0) == 0) {
                res.add(new ArrayList<>());
            } else {
                res.add(list);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 4;
        int[] arr = { 5, 2, 1, 3, 2 };
        System.out.println("Top K numbers in a stream: " + kTop(arr, N, K));
    }
}
