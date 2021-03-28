/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse two linked list
        // from start node to end node
        // sum = one(from l1) + two(from l2) + carry
        // add sum % 10 to result list and update carry = sum / 10;
        // until one and two both finish and carry = 0
        // reverse result
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode one = reverse(l1);
        ListNode two = reverse(l2);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (one != null || two != null || carry != 0) {
            int x = one == null ? 0 : one.val;
            int y = two == null ? 0 : two.val;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode resultNode = new ListNode(sum % 10);
            cur.next = resultNode;
            cur = cur.next;
            
            if (one != null) {
                one = one.next;
            }
            
            if (two != null) {
                two = two.next;
            }
        }
        
        return reverse(dummyHead.next);
    }
    
    private ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        
        ListNode prev = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
// Time Cost: visit each node once O(m + n), m is length of l1, n is length of l2
// Space Cost: O(m + n)