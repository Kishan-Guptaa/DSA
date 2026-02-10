class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
     PriorityQueue<Integer> large = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       if(small.size()==large.size()){
        large.add(num);
        small.add(large.remove());
       }else{
        small.add(num);
        large.add(small.remove());
       }
    }
    
    public double findMedian() {
        if(small.size()==large.size()){
            return (small.peek()+large.peek())/2.0;
        }
        else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */