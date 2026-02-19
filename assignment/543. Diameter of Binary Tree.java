/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 0;
        diameterofBT(root,diameter);
        return diameter[0];
    }
    private int diameterofBT(TreeNode root,int[]height){
        if(root == null){
            return 0;
        }
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = diameterofBT(root.left,height);
        rh[0] = diameterofBT(root.right,height);
        height[0] = Math.max(height[0],lh[0] + rh[0]);
        return 1+Math.max(lh[0],rh[0]);
    }
}