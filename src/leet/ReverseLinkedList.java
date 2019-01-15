package leet;

public class ReverseLinkedList {

    public static void main(String[] args) {

        Node head = buildLinkedList(0);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);

        head = buildLinkedList(1);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);

        head = buildLinkedList(2);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);

        head = buildLinkedList(3);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);

        head = buildLinkedList(10);
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);
    }

    private static Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = head;
        Node next = prev.next;
        Node nextNext = next.next;

        while (true) {
            next.next = head;
            prev.next = nextNext;

            head = next;

            if (nextNext == null) {
                break;
            }
            next = nextNext;
            nextNext = nextNext.next;
        }

        return head;
    }

    private static Node buildLinkedList(int n) {
        System.out.println("Build Linked List with size = " + n);

        Node head = null;
        Node prev = null;

        for (int i = 1; i <= n; i++) {
            Node node = new Node(i, null);
            if (prev != null) {
                prev.next = node;
            } else {
                head = node;
            }
            prev = node;
        }
        return head;
    }

    private static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr + " -> ");
            curr = curr.next;
        }
        System.out.println("[null]");
    }


    static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + val +
                    '}';
        }
    }
}
