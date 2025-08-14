// AddTwoNumbers.java
public class AddTwoNumbers {
    // Node definition for the linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }

        return dummy.next;
    }

    // Helper function to build a linked list from an array
    public static ListNode build(int[] a) {
        ListNode head = new ListNode(a[0]), cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " → " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Main method for local testing
    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers(); 
        ListNode l1 = build(new int[]{2,4,3});
        ListNode l2 = build(new int[]{5,6,4});
        ListNode res = sol.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        print(res); // Expected output: 7 → 0 → 8
    }
}
