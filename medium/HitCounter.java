class HitCounter {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int diff = timestamp - 300;
        if (diff > 0) {
            while (!queue.isEmpty() && queue.peek() <= diff) {
                queue.poll();
            } 
        } 
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */