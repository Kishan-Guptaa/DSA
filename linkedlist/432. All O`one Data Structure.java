// 432 All O'one Data Structure

import java.util.*;

class AllOne {
    // Bucket represents keys with the same count
    class Bucket {
        int count;
        LinkedHashSet<String> keys; // LinkedHashSet to maintain insertion order
        Bucket prev, next;
        Bucket(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
        }
    }
    
    private Map<String, Integer> keyCount; // Maps key -> its count
    private Map<Integer, Bucket> countBucket; // Maps count -> bucket of keys
    private Bucket head, tail; // Dummy head and tail of doubly linked list
    
    public AllOne() {
        keyCount = new HashMap<>();
        countBucket = new HashMap<>();
        head = new Bucket(-1); // Dummy head
        tail = new Bucket(-1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Helper method to add a bucket after the given bucket
    private void addBucketAfter(Bucket newBucket, Bucket prevBucket) {
        newBucket.prev = prevBucket;
        newBucket.next = prevBucket.next;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;
    }
    
    // Helper method to remove a bucket if it's empty
    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        countBucket.remove(bucket.count); // Remove from map
    }
    
    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0); // Get the current count of the key
        keyCount.put(key, count + 1); // Increase the count
        
        Bucket currBucket = countBucket.get(count);
        Bucket newBucket = countBucket.get(count + 1);
        
        if (newBucket == null) {
            newBucket = new Bucket(count + 1);
            countBucket.put(count + 1, newBucket);
            if (currBucket == null) {
                addBucketAfter(newBucket, head); // First entry, add after head
            } else {
                addBucketAfter(newBucket, currBucket); // Add newBucket after currBucket
            }
        }
        
        newBucket.keys.add(key); // Add the key to the new bucket
        
        if (currBucket != null) {
            currBucket.keys.remove(key); // Remove key from the old bucket
            if (currBucket.keys.isEmpty()) {
                removeBucket(currBucket); // Remove bucket if no keys remain
            }
        }
    }
    
    public void dec(String key) {
        int count = keyCount.get(key); // Get current count of the key
        if (count == 1) {
            keyCount.remove(key); // Remove key from the map if count is 1
        } else {
            keyCount.put(key, count - 1); // Decrease the count
        }
        
        Bucket currBucket = countBucket.get(count);
        Bucket newBucket = countBucket.get(count - 1);
        
        if (count > 1 && newBucket == null) {
            newBucket = new Bucket(count - 1);
            countBucket.put(count - 1, newBucket);
            addBucketAfter(newBucket, currBucket.prev); // Add new bucket before currBucket
        }
        
        if (newBucket != null) {
            newBucket.keys.add(key); // Add key to the new bucket
        }
        
        currBucket.keys.remove(key); // Remove key from the old bucket
        if (currBucket.keys.isEmpty()) {
            removeBucket(currBucket); // Remove bucket if no keys remain
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) {
            return ""; // No elements in the list
        }
        return tail.prev.keys.iterator().next(); // Get any key from the last bucket
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return ""; // No elements in the list
        }
        return head.next.keys.iterator().next(); // Get any key from the first bucket
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */