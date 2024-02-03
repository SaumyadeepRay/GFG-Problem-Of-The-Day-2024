// Implement Queue using Stacks

import java.util.LinkedList;
import java.util.Queue;

public class ImplementQueueUsingStacks {

    Queue<Integer> que;

    public ImplementQueueUsingStacks() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.add(x);
    }

    public int pop() {
        if (!que.isEmpty()) {
            return que.poll();
        } else {
            return 0;
        }
    }

    public int peek() {
        if (!que.isEmpty()) {
            return que.peek();
        } else {
            return 0;
        }
    }

    public boolean empty() {
        if (que.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());
        // return 1
        System.out.println(myQueue.pop());
        // return 1, queue is [2]
        System.out.println(myQueue.empty());
        // return false
    }
}
