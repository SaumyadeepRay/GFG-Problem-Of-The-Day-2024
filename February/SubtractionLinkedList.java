// Subtraction in Linked List

class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class SubtractionLinkedList {

    static Node head;

    // Building LinkedList
    public void last(int val) {
        Node newNode = new Node(val);
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

    public static Node subLinkedList(Node head1, Node head2) {
        // code here
        while (head1 != null && head1.data == 0) {
            head1 = head1.next;
        }

        while (head2 != null && head2.data == 0) {
            head2 = head2.next;
        }

        int s1 = getLength(head1);
        int s2 = getLength(head2);

        if (s1 == 0 && s2 == 0) {
            return new Node(0);
        }

        if (s2 > s1) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        if (s1 == s2) {
            Node current1 = head1;
            Node current2 = head2;
            while (current1.data == current2.data) {
                current1 = current1.next;
                current2 = current2.next;

                if (current1 == null) {
                    return new Node(0);
                }
            }
            if (current2.data > current1.data) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }

        head1 = reverse(head1);
        head2 = reverse(head2);
        Node ans = null;

        // This code snippet iterates through two linked lists, subtracts the
        // corresponding values from each list, and creates a new linked list with the
        // results. If the value from the first list is smaller than the value from the
        // second list, it subtracts
        while (head1 != null) {
            int n1 = head1.data;
            int n2 = 0;
            if (head2 != null) {
                n2 = head2.data;
            }

            if (n1 < n2) {
                if (head1.next != null) {
                    head1.next.data -= 1;
                }
                n1 += 10;
            }

            Node current = new Node(n1 - n2);
            current.next = ans;
            ans = current;

            head1 = head1.next;
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        // This code snippet iterates through a linked list until it finds a node with a
        // non-zero value. It then returns that node or null if there are no non-zero
        // nodes.
        while (ans != null && ans.next != null) {
            if (ans.data == 0) {
                ans = ans.next;
            } else {
                break;
            }
        }
        return ans;
    }

    // This code snippet calculates the length of a linked list by iterating through
    // each node and incrementing a counter until the end of the list is reached.
    // The final count is returned.
    public static int getLength(Node head) {
        int cnt = 0;
        for (Node current = head; current != null; current = current.next) {
            cnt++;
        }
        return cnt;
    }

    // This code snippet reverses a linked list by changing the direction of the
    // pointers between nodes. It starts from the head node and iteratively updates
    // the next pointers to reverse the list. Finally, it returns the new head node.
    public static Node reverse(Node head) {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // This code snippet prints the data stored in each node of a linked list,
    // starting from the head node and moving to the next node until the end of the
    // list is reached.
    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] LinkedList1 = { 0, 0, 6, 3 };
        SubtractionLinkedList list1 = new SubtractionLinkedList();
        for (int i = 0; i < LinkedList1.length; i++) {
            list1.last(LinkedList1[i]);
        }

        Node head1 = head;

        head = null;

        int[] LinkedList2 = { 7, 1, 0 };
        SubtractionLinkedList list2 = new SubtractionLinkedList();
        for (int i = 0; i < LinkedList2.length; i++) {
            list2.last(LinkedList2[i]);
        }

        Node head2 = head;

        Node result = subLinkedList(head1, head2);

        System.out.println("Subtraction in Linked List: ");

        head = result;

        print();
    }
}
