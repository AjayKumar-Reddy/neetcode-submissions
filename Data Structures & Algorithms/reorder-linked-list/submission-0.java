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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prevSlow=null;
        ListNode l1=head;
        while(fast.next!=null && fast.next.next!=null){
            prevSlow=slow;
            slow=slow.next;
            fast=fast.next.next;

        }

        ListNode l2 = slow.next;
        slow.next = null;
        //reverse
        ListNode curr=l2;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        l2=prev;
        while(l1!=null && l2!=null){
            ListNode n1=l1.next;
            ListNode n2=l2.next;

            l1.next=l2;
            l2.next=n1;

            l1=n1;
            l2=n2;
        }

        

    }
}
