// Reverse First K elements of Queue

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsQueue {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> stack = new Stack<>();

        // This code snippet pushes the first k elements from a queue (q) onto a stack
        // (stack).
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // This code snippet transfers all elements from a stack to a queue by
        // continuously popping elements from the stack and adding them to the queue
        // until the stack is empty.
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        int i = 0;
        // This code snippet rotates the elements in a queue by removing and adding them
        // back in a loop until a certain condition is met.
        while (i < q.size() - k) {
            q.add(q.remove());
            i++;
        }

        return q;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Queue<Integer> que = new LinkedList<>();
        for (int val : arr) {
            que.add(val);
        }
        int k = 3;
        System.out.println("Reverse First K elements of Queue: " + modifyQueue(que, k));
    }
}
