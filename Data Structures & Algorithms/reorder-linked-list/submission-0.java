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
        if(head==null || head.next==null){
            return;
        }
        //1. find  middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //2. dusre part ko reverse kiya
        ListNode prev=null;
        ListNode current=slow.next;
        slow.next=null;// list ko beech se tod diya
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        // 3. Merge karo
       ListNode first=head, second=prev;
        while(second !=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }
    }
}
