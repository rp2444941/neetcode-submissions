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
        // 3. Merge karo (Tumhara Dummy Node wala logic)
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        ListNode list1 = head;
        ListNode list2 = prev; 

        while (list1 != null && list2 != null) {
            // Step 1: list1
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;

            // Step 2: list2 
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }

        // Jo dabba bach gaya (agar list1 badi thi), use aakhir mein jod do
        tail.next = (list1 != null) ? list1 : list2;
       
    }
}
