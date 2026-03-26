package neetcode150;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // save next
            curr.next = prev; // reverse link
            prev = curr; // move prev forward
            curr = temp; // move curr forward
        }

        return prev;
    }
    
}