
class Q2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        // Carry will hold the overflow digit when sum >= 10
        int carry = 0;

        while (l1 != null || l2 != null) {
            // If l1 (or l2) has been done, use 0 as its digit
            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;

            int sum = n1 + n2 + carry;

            // Create a new node for the current digit (sum % 10)
            if (head == null) {
                // First node becomes both head and tail
                head = tail = new ListNode(sum % 10);
            } else {
                // Append new node and move tail forward
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10; // update

            // Advance input pointers if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's still remaining carry after the last digits,then append it
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        // Return the head of the summed list
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
