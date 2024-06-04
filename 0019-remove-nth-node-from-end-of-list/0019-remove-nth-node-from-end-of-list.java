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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //edge case.
        if(head == null) return null;
        //creating two pointer forward and backward.
        //we moving forward pointer n-1 times. forwaard.
        ListNode forward = head;

        for(int i=1; i<n; i++)
        {
            forward = forward.next;
        }

        //now declare & initialize backward pointer.
        ListNode backward = head;
        //creating temp pointer to take previous pointer.
        ListNode prev = null;

        //now we running loop to find out answer.
        while(forward.next != null)
        {
            prev = backward;
            backward = backward.next;
            forward = forward.next;
        }

        //if prev == null means head and removed node is same.
        if(prev == null)
        {
            return head.next;
        }
        else
        {
            prev.next = backward.next;
        }

        return head;
    }
}