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
    public int minCameraCover(TreeNode root) {
        int[] dp = helper(root);
        // dp[0] = if node has camera, min number of camera if all tree covered
        // dp[1] = if node do not have camera, but it children has camera, min number of camera if all tree covered
        // dp[2] = if node do not have camera and it children do not have camera, min number of camera if all tree covered
        return Math.min(dp[0], dp[1]);
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] { 9999, 0, 0 };
        }
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        int[] nodeResult = new int[3];
        // if node has camera, left and right will be covered, so we chose the min value
        nodeResult[0] = 1 + Math.min(Math.min(left[0], left[1]), left[2]) + Math.min(Math.min(right[0], right[1]), right[2]);
        // if node does not have camera and we hope it is covered by children
        nodeResult[1] = Math.min(Math.min(left[1] + right[0], left[0] + right[1]), left[0] + right[0]);
        // if node does not have camera and we hope it is covered by parent
        nodeResult[2] = left[1] + right[1];
        return nodeResult;
    } 
}