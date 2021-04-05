class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;
    public MedianFinder() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        larger.offer(num);
        smaller.offer(larger.poll());
        
        if (larger.size() < smaller.size()) {
            larger.offer(smaller.poll());
        }
    }
    
    public double findMedian() {
        if (larger.size() > smaller.size()) {
            return larger.peek();
        }
        
        return (larger.peek() + smaller.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */