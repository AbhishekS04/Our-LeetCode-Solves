// Single clean implementation for LeetCode 2: Add Two Numbers.
// Compile (Windows PowerShell):  javac AddTwoNumbers.java
// Run default example:            java AddTwoNumbers
// Run with custom numbers:        java AddTwoNumbers 342 465
// (Numbers are interpreted normally; internally digits are reversed.)
public class AddTwoNumbers {
    // Nested static ListNode to avoid name clashes with other problems.
    public static class ListNode {
        int val;
        ListNode next;
    ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
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

    private static ListNode fromDigits(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int d : digits) { cur.next = new ListNode(d); cur = cur.next; }
        return dummy.next;
    }

    private static void printList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) { sb.append(node.val); if (node.next != null) sb.append(" -> "); node = node.next; }
        System.out.println(sb.toString());
    }

    private static int[] toDigitsReversed(String s) {
        int n = s.length();
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(n - 1 - i);
            if (c < '0' || c > '9') throw new IllegalArgumentException("Non-digit: " + c);
            out[i] = c - '0';
        }
        return out;
    }

    public static void main(String[] args) {
        if (args.length != 0 && args.length != 2) {
            System.out.println("Usage: java AddTwoNumbers [num1 num2]");
            System.out.println("Example: java AddTwoNumbers 342 465");
            return;
        }

        int[] a = {2,4,3}; // 342 (stored reversed as 2->4->3)
        int[] b = {5,6,4}; // 465 (stored reversed as 5->6->4)
        if (args.length == 2) {
            try {
                a = toDigitsReversed(args[0]);
                b = toDigitsReversed(args[1]);
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
                return;
            }
        }
        AddTwoNumbers solver = new AddTwoNumbers();
        ListNode res = solver.addTwoNumbers(fromDigits(a), fromDigits(b));
        printList(res); // expected 7 -> 0 -> 8 for default
    }
}
