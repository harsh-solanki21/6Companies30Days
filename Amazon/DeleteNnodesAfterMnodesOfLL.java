package Amazon;

public class DeleteNnodesAfterMnodesOfLL {

    static class Node {
        int data;
        Node next;
    }

    static Node push(Node headRef, int newData) {
        Node new_node = new Node();
        new_node.data = newData;
        new_node.next = (headRef);
        (headRef) = new_node;

        return headRef;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;

        while (curr != null) {
            // Skip M nodes
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            // If we reached end of list, then return
            if (curr == null) {
                return;
            }

            // Start from next node and delete N nodes
            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {
                Node temp = t;
                t = t.next;
            }

            // Link the previous list with remaining nodes
            curr.next = t;

            // Set current pointer for next iteration
            curr = t;

        }

    }

    public static void main(String args[]) {

        Node head = null;
        int M = 2, N = 3;
        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        System.out.println("M = " + M + ", N = " + N);
        System.out.println("Given Linked list is : ");
        printList(head);

        skipMdeleteN(head, M, N);

        System.out.println("Linked list after deletion is : ");
        printList(head);

    }

}
