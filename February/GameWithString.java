// Game with String

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class GameWithString {

    public static int minValue(String s, int k) {

        // This code creates a priority queue of integers in descending order using a
        // comparator from the Collections class.
        Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Character, Integer> map = new HashMap<>();

        // Storing the frequency in HashMap
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Adding frequencies in the que
        for (int a : map.values()) {
            que.add(a);
        }

        // This code decrements the value of each element in a queue `k` times by
        // polling an element, decrementing it by one, and then adding it back to the
        // queue.
        while (k > 0) {
            int a = que.poll();
            a--;
            que.add(a);
            k--;
        }

        int sum = 0;

        // This code calculates the sum of the squares of all elements in a queue by
        // continuously removing elements from the queue and adding their squares to the
        // sum until the queue is empty.
        while (!que.isEmpty()) {
            sum += que.peek() * que.peek();
            que.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "abccc";
        int k = 1;
        System.out.println("Game with String: " + minValue(s, k));
    }
}
