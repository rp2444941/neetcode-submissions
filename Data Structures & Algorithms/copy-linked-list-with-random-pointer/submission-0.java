/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Step 1. Clone node aur beech mein ghusao
        Node curr = head;
        while(curr != null){
            Node next = curr.next; // Agle asli dabbe ka backup
            Node copy = new Node(curr.val); // Naya judwaa dabba
            
            // Teer sahi se jodo: Asli -> Copy -> Next Asli
            curr.next = copy;
            copy.next = next; 
            
            // FIX: Curr ko agle asli dabbe par bhejo
            curr = next; 
        }
        
        // Step 2: Random pointers set kiya (Tumhara ye part ekdum sahi tha!)
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Do-do kadam koodo (Kyunki beech mein copy hain)
        }
        
        // Step 3: Dono lists ko alag karo (Tumhara Dummy Node pattern - Correct!)
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        curr = head;
        while(curr != null){
            Node copy = curr.next;
            curr.next = copy.next; // Asli list ka purana rishta wapas joda
            
            // Nayi list mein dabba joda
            tail.next = copy;
            tail = tail.next;

            // Aage badhaya
            curr = curr.next;
        }
        return dummyHead.next;
        
    }
}
