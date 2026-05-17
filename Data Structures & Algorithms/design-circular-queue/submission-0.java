class MyCircularQueue {
int[] q;
    int head;
    int tail;
    int count; // Kitne log abhi queue mein hain
    int k;     // Total capacity
    public MyCircularQueue(int k) {
        this.k = k;
        this.q = new int[k];
        this.head = 0;
        this.tail = -1; // -1 isliye taaki pehla element 0 par aaye (tail + 1)
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false; // Jagah nahi hai
        }
        // Tail ko gol ghumao aur value daalo
        tail = (tail + 1) % k; 
        q[tail] = value;
        count++; // Ek banda badh gaya
        return true;
        
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false; // Hataane ke liye kuch nahi hai
        }
        // Head ko gol ghumao (Pichla element automatically ignore ho jayega)
        head = (head + 1) % k;
        count--; // Ek banda kam ho gaya
        return true;
        
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[head];
        
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[tail];
        
    }
    
    public boolean isEmpty() {
        return count == 0;
        
    }
    
    public boolean isFull() {
        return count == k;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */