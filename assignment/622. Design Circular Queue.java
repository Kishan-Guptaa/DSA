class MyCircularQueue {
    private int head;
    private int[] queue;
    private int capacity;
    private int count;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        head = 0;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        int tail = (count + head) % capacity;
        queue[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[head];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int tail = (head + count - 1) % capacity;
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
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