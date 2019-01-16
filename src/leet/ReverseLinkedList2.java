package leet;

public class ReverseLinkedList2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" + val +
                    '}';
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode next = prev.next;
        ListNode nextNext = next.next;

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

    public ListNode buildLinkedList(int n) {
        System.out.println("Build Linked List with size = " + n);

        ListNode head = null;
        ListNode prev = null;

        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            if (prev != null) {
                prev.next = node;
            } else {
                head = node;
            }
            prev = node;
        }
        return head;
    }

    public void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ReverseLinkedList2 r2 = new ReverseLinkedList2();
        ListNode head = r2.buildLinkedList(5);
        r2.printLinkedList(r2.reverseList(head));
        head = r2.buildLinkedList(0);
        r2.printLinkedList(r2.reverseList(head));
        head = r2.buildLinkedList(1);
        r2.printLinkedList(r2.reverseList(head));
        head = r2.buildLinkedList(2);
        r2.printLinkedList(r2.reverseList(head));
    }
}
