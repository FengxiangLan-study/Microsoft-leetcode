class Solution {
    public int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        // record max number of left part, and current max number
        // if A[i] < leftMax, means
        // we should count A[i] in left part, so leftMax = curMax and update result index
        // else
        // the right part may still have smaller element, so we update curMax, and not update result index
        int leftMax = A[0];
        int curMax = A[0];
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= leftMax) {
                curMax = Math.max(A[i], curMax);
            } else {
                leftMax = curMax;
                result = i;
            }
        }
        
        return result + 1;
    }
}
// Time Cost: O(n)
// Space Cost: O(1)