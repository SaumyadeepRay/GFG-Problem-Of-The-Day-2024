// Merge 2 sorted linked list in reverse order

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }

    Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }
}

public class MergeSortedLinkedList {

    Node head;

    public void addLast(int val) {
        Node newNode = new Node(val);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp = newNode;
        }
    }

    public static Node mergeResult(Node node1, Node node2) {
        // Your code here
        Node l1 = reverse(node1);
        Node l2 = reverse(node2);

        Node dummy = new Node(0);
        Node temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return dummy.next;
    }

    public static Node reverse(Node merge) {
        Node currentNode = merge;
        Node prevNode = null;

        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = next;
        }

        return prevNode;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3 };
        int[] arr2 = { 2, 4 };
        MergeSortedLinkedList node1 = new MergeSortedLinkedList();
        for (int i = 0; i < arr1.length; i++) {
            node1.addLast(arr1[i]);
        }
        MergeSortedLinkedList node2 = new MergeSortedLinkedList();
        for (int i = 0; i < arr2.length; i++) {
            node2.addLast(arr2[i]);
        }
        System.out.println("Merge 2 sorted linked list in reverse order: " + mergeResult(node1, node2));
    }

    private static Node mergeResult(MergeSortedLinkedList node1, MergeSortedLinkedList node2) {
        return null;
    }
}
