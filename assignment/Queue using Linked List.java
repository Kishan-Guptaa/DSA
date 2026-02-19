// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    private Node front;
    private Node rear;
    private int size;
    public myQueue() {
        // Initialize your data members
        front = null;
        rear = null;
        size = 0;
        
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return front == null;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        Node newNode  = new Node(x);
        if(front == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void dequeue() {
        // Removes the front element of the queue
        if(isEmpty()){
            return ;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return size;
    }
}
