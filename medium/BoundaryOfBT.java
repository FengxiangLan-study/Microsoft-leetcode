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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        
        TreeNode cur = root.left;
        // get left boundary
        while (cur != null) {
            if (!isLeaf(cur)) {
                result.add(cur.val);
            }
            cur = cur.left == null ? cur.right : cur.left;
        }
        
        // get leaves
        addLeaves(result, root);
        
        // get right boundary
        Deque<Integer> stack = new LinkedList<>();
        cur = root.right;
        while (cur != null) {
            if (!isLeaf(cur)) {
                stack.offerFirst(cur.val);
            }
            cur = cur.right == null ? cur.left : cur.right;
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pollFirst());
        }
        
        return result;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    
    private void addLeaves(List<Integer> result, TreeNode root) {
        if (isLeaf(root)) {
            result.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(result, root.left);
            }
            if (root.right != null) {
                addLeaves(result, root.right);
            }
        }
    }
}

// Time Cost: O(n)
// Space Cost: O(n)