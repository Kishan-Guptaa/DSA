import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    int getLevel(Node root, int X) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.data == X)
                    return level;

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
            level++;
        }

        return 0; 
    }
}
