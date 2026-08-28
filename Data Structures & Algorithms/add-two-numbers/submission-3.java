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
        ListNode ans=new ListNode(-1);
        ListNode finans=ans;
        int carry=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null || temp2!=null){
            int ele1=(temp1!=null) ? temp1.val : 0;
            int ele2=(temp2!=null) ? temp2.val : 0;
            int sum=ele1+ele2+carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node=new ListNode(sum);
            finans.next=node;
            finans=finans.next;
            temp1=(temp1!=null) ? temp1.next : temp1;
            temp2=(temp2!=null) ? temp2.next : temp2;
            
        }
        if(carry!=0){
            finans.next=new ListNode(carry);
        }
        
        return ans.next;

    }
}
