/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise,
add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
evict the least recently used key.

Follow up:
Could you do get and put in O(1) time complexity?
*/
class LRUCache {
  static class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public void update(int newValue) {
      this.value = newValue;
    }
  }

  private Node head;
  private Node tail;
  // use map then get will be o(1)
  private Map<Integer, Node> map;
  private int cap;
  public LRUCache(int capacity) {
      this.map = new HashMap<Integer, Node>();
      this.cap = capacity;
  }
  
  public int get(int key) {
      Node node = map.get(key);
      if (node == null) {
        return -1;
      } else {
        delete(node);
        insert(node);
        return node.value;
      }
  }
  
  public void put(int key, int value) {
      Node node = map.get(key);
      if (node == null) {
        // if node does not exist, add a new one
        if (map.size() >= cap) {
          // if size will exceed, first remove least recently used key, which is head
          map.remove(head.key);
          delete(head);
        }
        // add new node to linkedlist and map
        node = new Node(key, value);
        insert(node);
        map.put(key, node);
      } else {
        // if node exists, update it value, and update its position in linkedlist
        node.update(value);
        delete(node);
        insert(node);
      }
  }

  private void delete(Node node) {
    // delete one node, we need update let its prev node points to its next node,
    // and its next node points to its prev nodes
    // then we need update head and tail nodes
    if (node.prev != null) {
      node.prev.next = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    }

    if (head == node) {
      head = node.next;
    }

    if (tail == node) {
      tail = node.prev;
    }
    node.prev = null;
    node.next = null;
  }

  private void insert(Node node) {
    // if linkedlist does not have any element, node will be head and tail
    if (head == null) {
      head = node;
      tail = node;
    } else {
      // else add this node to tail
      tail.next = node;
      node.prev = tail;
      tail = tail.next;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 // Time Cost: O(1)
 // Space Cost: O(n) n is capacity