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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        for(int i=1;i<lists.length;i++){
            ListNode node=mergeTwoLists(lists[i-1],lists[i]);
            lists[i]=node;
        }
        return lists[lists.length-1];
    }
    public ListNode mergeTwoLists(ListNode first,ListNode sec){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode temp1=first;
        ListNode temp2=sec;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                curr.next=temp1;
                temp1=temp1.next;
                curr=curr.next;
            } else {
                curr.next=temp2;
                temp2=temp2.next;
                curr=curr.next;
            }
        }
        if(temp1!=null){
            curr.next=temp1;
            return dummy.next;
        } 
        if(temp2!=null){
            curr.next=temp2;
            return dummy.next;
        }
        return dummy.next;
    }
}
