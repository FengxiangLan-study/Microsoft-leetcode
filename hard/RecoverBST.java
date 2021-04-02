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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            
            cur = stack.pollFirst();
            if (prev != null && prev.val > cur.val) {
                second = cur;
                if (first == null) {
                    first = prev;
                } else {
                    break;
                }
            }
            prev = cur;
            cur = cur.right;
        }
        
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}

// Time Cost: O(n)
// Space Cost: O(1)