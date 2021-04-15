/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // since the node has random pointer, means when we copy one node, the random node might already be created, to avoid create same node twice, we need a map to record the node we already created.
        if (head == null) {
            return head;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node newHead = new Node(head.val);
        map.put(cur, newHead);
        while (cur != null) {
            if (cur.next != null) {
                if (!map.containsKey(cur.next)) {
                    Node newNext = new Node(cur.next.val);
                    map.put(cur.next, newNext);
                }
                map.get(cur).next = map.get(cur.next);
            }
            
            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    Node newRandom = new Node(cur.random.val);
                    map.put(cur.random, newRandom);
                }
                map.get(cur).random = map.get(cur.random);
            }
            
            cur = cur.next;
        }
        return newHead;
    }
}