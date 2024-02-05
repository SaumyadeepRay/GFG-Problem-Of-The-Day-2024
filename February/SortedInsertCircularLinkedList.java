// Sorted insert for circular linked list

class Node {
    int data;
    Node next;
}

public class SortedInsertCircularLinkedList {

    static Node head;

    // Building LinkedList
    public void last(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public static Node sortedInsert(Node head, int data) {

        Node newNode = new Node();
        newNode.data = data;

        // if circular linked list is empty
        if (head == null) {
            // point it to itself
            newNode.next = newNode;
            return newNode;
        }

        // insert at beginning
        if (head.data >= data) {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            return newNode;
        }

        // insert at a position in between or end
        else {
            Node temp = head;
            while (temp.next != head && temp.next.data < data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            return head;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] LinkedList = { 1, 2, 4 };
        SortedInsertCircularLinkedList list = new SortedInsertCircularLinkedList();
        for (int i = 0; i < n; i++) {
            list.last(LinkedList[i]);
        }
        int data = 2;
        System.out.println("Decimal Equivalent of Binary Linked List: " + sortedInsert(head, data));
    }
}
