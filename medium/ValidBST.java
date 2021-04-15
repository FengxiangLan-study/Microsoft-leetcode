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
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            
            cur = stack.pollFirst();
            if (prev != null && prev.val >= cur.val) {
                return false;
            }
            prev = cur;
            cur = cur.right;
        }
        return true;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        
        if (max != null && node.val >= max) {
            return false;
        }
        
        boolean left = node.left != null ? helper(node.left, min, node.val) : true;
        if (left) {
            boolean right = node.right != null ? helper(node.right, node.val, max) : true;
            return right;
        } else {
            return false;
        }
    }
}