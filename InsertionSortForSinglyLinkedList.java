// Insertion Sort for Singly Linked List

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionSortForSinglyLinkedList {

    Node head;

    public void addLast(int val) {
        Node newNode = new Node();
        newNode.data = val;
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node lasNode = head;
            while (lasNode.next != null) {
                lasNode = lasNode.next;
            }
            lasNode.next = newNode;
            newNode.next = head;
        }
    }

    public static Node insertionSort(Node head_ref) {
        Node dummy = new Node(-1);
        while (head_ref != null) {
            Node next = head_ref.next;
            Node temp = dummy;
            while (temp.next != null && temp.next.data < head_ref.data) {
                temp = temp.next;
            }
            head_ref.next = temp.next;
            temp.next = head_ref;
            head_ref = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortForSinglyLinkedList head_ref = new InsertionSortForSinglyLinkedList();
        head_ref.addLast(30);
        head_ref.addLast(23);
        head_ref.addLast(28);
        head_ref.addLast(30);
        head_ref.addLast(11);
        head_ref.addLast(14);
        head_ref.addLast(19);
        head_ref.addLast(16);
        head_ref.addLast(21);
        head_ref.addLast(25);
        System.out.println("Insertion Sort for Singly Linked List: " + insertionSort(head_ref.head));
    }
}
