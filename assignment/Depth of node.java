/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int data) { data = data; left = null, right = null }
 * }
 **/

class Solution {
    public int maxDepth(TreeNode root) {
        //your code goes here
        if(root == null){
            return 0;
        }
        int leftside = maxDepth(root.left);
        int rightSide = maxDepth(root.right);
        return 1 + Math.max(leftside,rightSide);
    }
}