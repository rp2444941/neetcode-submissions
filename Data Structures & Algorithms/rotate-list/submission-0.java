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
    public ListNode rotateRight(ListNode head, int k) {
       if (head == null || head.next == null || k == 0) return head;
       // 1.  Length  nikala
        ListNode tail=head;
        int length=1;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        // 2. Extra rotations hatao
        k=k%length;
        if(k==0) return head;
        //3. circular list
        tail.next=head;
        // 4. L - k steps aage jao naya tail dhoondhne ke liye
        ListNode newTail=head;
        for(int i=0;i<length-k-1;i++){
            newTail=newTail.next;
        }
        // 5. Naya head set karo aur connection tod do
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}