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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        
        ListNode dummy=null;
        ListNode prevTail=null;
        while(curr!=null){
            int count=1;
            ListNode fast=curr;
            ListNode temp=curr;
            while(count!=k && fast!=null){
                fast=fast.next;
                count++;
            }
            if(fast==null) break;
            curr=fast.next;
            fast.next=null;
            ListNode node=reverse(temp);
            if(dummy==null) dummy=node;
            if(prevTail!=null) prevTail.next=node;
            temp.next=curr;
            prevTail=temp;
            

        }
        return dummy;
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
}
