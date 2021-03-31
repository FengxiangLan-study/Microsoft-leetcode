/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        return result.toString();
    }
    
    private void serialize(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }
        
        result.append('[');
        result.append(node.val);
        for (Node child : node.children) {
            serialize(child, result);
        }
        
        result.append(']');
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        Deque<Node> stack = new LinkedList<>();      
        Node root = new Node(0, new ArrayList<>());        
        stack.offerFirst(root);
        char[] array = data.toCharArray();
        int i = 0;
        while (i < array.length) {
            if (array[i] == '[') {
                i++;
                int num = 0;
                while(array[i] >= '0' && array[i] <= '9') {
                    num = num * 10 + (array[i] - '0');
                    i += 1;
                }
                Node newNode = new Node(num, new ArrayList<Node>());
                stack.peekFirst().children.add(newNode);
                stack.offerFirst(newNode);
                i--;
            }
            
            if (array[i] == ']') {
                stack.pollFirst();
            }
            
            i++;
        }
        root = stack.pollFirst();
        return root.children.size() == 0 ? null : root.children.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));