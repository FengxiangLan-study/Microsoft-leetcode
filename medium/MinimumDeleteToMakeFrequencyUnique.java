class Solution {
    public int minDeletions(String s) {
        // count is minDelettions
        // using array to record frequency
        // using maxHeap to store frequency
        // if top element's frequency is equal to second one, decrease first one's frequency by 1, and count++
        // else directly pop top element;
        // until maxHeap is empty
        char[] array = s.toCharArray();
        int[] frequency = new int[26];
        for (char c : array) {
          frequency[c - 'a']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer freq1, Integer freq2) {
                if (freq1 == freq2) {
                    return 0;
                }
                
                return freq1 > freq2 ? -1 : 1;
            }
        });
        
        for (int freq : frequency) {
          if (freq != 0) {
            maxHeap.offer(freq);
          }
        }
        
        int count = 0;
        while (!maxHeap.isEmpty()) {
            int topFreq = maxHeap.poll();
            if (maxHeap.isEmpty()) {
                return count;
            }
            
            if (topFreq == maxHeap.peek()) {
                if (topFreq > 1) {
                    maxHeap.offer(topFreq - 1);
                }
                count++;
            }
        }
        return count;
        
    }
}

// Time Cost: O(n), we visit each character once
// Space Cost: O(1), since the size of array is 26 no matter length of string