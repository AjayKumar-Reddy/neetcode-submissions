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
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int num1=(l1!=null) ? l1.val:0;
            int num2=(l2!=null) ? l2.val:0;

            int sum=num1+num2+carry;
            ListNode newNode=new ListNode(sum%10);
            curr.next=newNode;
            curr=curr.next;
            carry=sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummy.next;
    }
}
