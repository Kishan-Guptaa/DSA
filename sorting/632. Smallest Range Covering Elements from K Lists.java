import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority queue (min-heap) to store elements from the lists
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int max = Integer.MIN_VALUE; // Track the maximum value in the current range
        int start = 0, end = Integer.MAX_VALUE; // Track the smallest range

        // Initialize the heap with the first element from each list
        for (int i = 0; i < nums.size(); i++) {
            int element = nums.get(i).get(0);
            minHeap.offer(new int[] {element, i, 0}); // {value, list index, element index}
            max = Math.max(max, element); // Update the current max element
        }

        // Process the heap
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll(); // Get the smallest element
            int value = current[0], listIndex = current[1], elementIndex = current[2];

            // Check if the current range [value, max] is smaller than the previous range
            if (max - value < end - start) {
                start = value;
                end = max;
            }

            // If the current list has more elements, add the next element from the same list to the heap
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[] {nextValue, listIndex, elementIndex + 1});
                max = Math.max(max, nextValue); // Update the current max element
            }
        }

        return new int[] {start, end};
    }
}