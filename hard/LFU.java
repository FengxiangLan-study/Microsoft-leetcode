import java.io.*;
class LFUCache {
    static class Cell {
        int key;
        int value;
        int timestamp;
        int freq;
        public Cell(int key, int value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.freq = 1;
            
        }
    }
    
    private PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
        @Override
        public int compare(Cell one, Cell two) {
            if (one.freq == two.freq) {
                return one.timestamp < two.timestamp ? -1 : 1;
            }
            
            return one.freq < two.freq ? -1 : 1;
        }
    });
    private Map<Integer, Cell> map;
    private int cap;
    private int timestamp = 1;
    public LFUCache(int capacity) {
        this.map = new HashMap<Integer, Cell>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        Cell cell = map.get(key);
        if (cell == null) {
            return -1;
        } else {
            minHeap.remove(cell);
            cell.freq++;
            cell.timestamp = timestamp++;
            minHeap.offer(cell);
            return cell.value;
        }
    }
    
    public void put(int key, int value) {
        Cell cell = map.get(key);
        if (cap == 0) {
            return;
        }
        if (cell == null) {
            if (map.size() >= cap) {
                cell = minHeap.poll();
                map.remove(cell.key);
            }
            Cell newCell = new Cell(key, value, timestamp++);
            minHeap.offer(newCell);
            map.put(key, newCell);
        } else {
            minHeap.remove(cell);
            cell.value = value;
            cell.freq++;
            cell.timestamp = timestamp++;
            minHeap.offer(cell);
            map.put(key, cell);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 // Time Cost: O(logn)
 // Space Cost: O(n)