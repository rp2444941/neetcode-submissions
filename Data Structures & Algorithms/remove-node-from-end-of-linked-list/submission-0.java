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
// 1. Dummy node banaya
ListNode dummy=new ListNode(0);
dummy.next=head;
ListNode slow=dummy;
ListNode fast=dummy;
// 2. Fast pointer ko N kadam aage bhejo
for(int i=1;i<=n;i++){
    fast=fast.next;
}
// 3. Dono ko saath chalao jab tak fast end pe na pahunche
while(fast.next !=null){
    slow=slow.next;
    fast=fast.next;
}
//4.Node delete karo (connection bypass)
slow.next=slow.next.next;

// dummy.next hi hamari asli list ka head hai
return dummy.next;

    }
}
