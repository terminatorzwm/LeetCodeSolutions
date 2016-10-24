public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        int firstSum = l1.val + l2.val + carry;
        result = new ListNode(firstSum >= 10 ? firstSum % 10 : firstSum);
        carry = firstSum >= 10 ? 1 : 0;
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        ListNode p = result;
        while (l1 != null || l2 != null) {
            int a, b;
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            int tmpSum = a + b + carry;
            p.next = new ListNode(tmpSum >= 10 ? tmpSum % 10 : tmpSum);
            carry = tmpSum >= 10 ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            p = p.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return result;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}