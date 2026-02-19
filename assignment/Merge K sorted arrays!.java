import java.util.*;

public class Solution {

    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int[] solve(int[][] A) {
        int K = A.length;
        int N = A[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        for (int i = 0; i < K; i++) {
            minHeap.offer(new Node(A[i][0], i, 0));
        }

        int[] result = new int[K * N];
        int index = 0;

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result[index++] = curr.value;

            if (curr.col + 1 < N) {
                minHeap.offer(new Node(
                    A[curr.row][curr.col + 1],
                    curr.row,
                    curr.col + 1
                ));
            }
        }

        return result;
    }
}
