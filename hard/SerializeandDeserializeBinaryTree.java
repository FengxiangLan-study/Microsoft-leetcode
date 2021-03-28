/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                result += (Integer.toString(cur.val) + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                result += "null,";
            }
        }
        
        return result.length() > 0 ? result : result.substring(0, result.length());
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer. parseInt(array[0]));
        TreeNode cur = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                if (count == 0) {
                    cur = queue.poll();
                    cur.left = node;
                    count++;
                } else {
                    cur.right = node;
                    count = 0;
                }
                queue.offer(node);
            } else {
                if (count == 0) {
                    cur = queue.poll();
                    cur.left = null;
                    count++;
                } else {
                    cur.right = null;
                    count = 0;
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// Time Cost: O(n)
// Space Cost: O(n)