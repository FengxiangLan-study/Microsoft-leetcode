/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        if (node.right != null) {
            return findInChildren(node.right);
        }
        
        return findInParent(node.parent, node.val);
    }
    
    private Node findInChildren(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        
        return findInChildren(node.left);
    }
    
    private Node findInParent(Node node, int value) {
        if (node == null || node.val > value) {
            return node;
        }
        
        return findInParent(node.parent, value);
    }
}
// Time Cost: O(h) h is height of tree
// Space Cost: O(h) 