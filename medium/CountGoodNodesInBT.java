/*
Given a binary tree root, a node X in the tree is named good if in the path from root
to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
*/
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
    public int goodNodes(TreeNode root) {
        int[] count = { 0 };
        if (root == null) {
            return 0;
        }
        goodNodes(root, root.val, count);
        return count[0];
    }
    
    private void goodNodes(TreeNode node, int max, int[] count) {
        if (node == null) {
            return;
        }
        
        // one node is good, if its value is maximun of (root to this node);
        if (node.val >= max) {
            count[0]++;
            
        }
        
        // update max
        max = Math.max(node.val, max);
        goodNodes(node.left, max, count);
        goodNodes(node.right, max, count);
    }
}
// Time Cost: since we visit each nodes once, O(n)
// Space Cost: O(h) h is heigh of tree 