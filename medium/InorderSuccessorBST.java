/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        TreeNode successor = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val <= p.val) {
                cur = cur.right;
            } else {
                successor = cur;
                cur = cur.left;
            }
        }
        return successor;
    }
}