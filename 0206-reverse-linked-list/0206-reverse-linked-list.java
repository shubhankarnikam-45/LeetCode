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
    public ListNode reverseList(ListNode head) {
        
        //head is null then.
        if(head == null) return null;

        ListNode temp = null;
        //creating temporary variable for traversal.
        ListNode v1 = head;
        ListNode v2 = null;

        while(true)
        {
            v2 = v1.next;
            v1.next = temp;
            temp = v1;
            v1 = v2;
            //loop break condition.
            if(v1 == null) break;
        }

        head = temp;
        //code
        return head;
    }
}