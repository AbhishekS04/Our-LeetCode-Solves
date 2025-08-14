// Single clean implementation. Compile: javac AddTwoNumbers.java  Run: java AddTwoNumbers
public class AddTwoNumbers {
    // Nested static ListNode to avoid name clashes with other problems.
    static class ListNode {
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
        int[] a = {2,4,3}; // 342
        int[] b = {5,6,4}; // 465
        if (args.length >= 2) { a = toDigitsReversed(args[0]); b = toDigitsReversed(args[1]); }
        AddTwoNumbers solver = new AddTwoNumbers();
        ListNode res = solver.addTwoNumbers(fromDigits(a), fromDigits(b));
        printList(res); // expected 7 -> 0 -> 8
    }
}
