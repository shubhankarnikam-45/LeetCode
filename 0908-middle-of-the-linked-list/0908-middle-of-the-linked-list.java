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
    public ListNode middleNode(ListNode head) {
        
        //creating two pointer slow and fast.
        ListNode slow = head;
        ListNode fast = head;

        while(true)
        {
            //loop break condition 1.
            if(fast.next == null) break;
            
            slow = slow.next;
            //loop break condition 2
            if(fast.next.next == null) break;
            fast = fast.next.next;
        }
        //return slow pointer that points to the middle of linked list.
        return slow;
    }
}