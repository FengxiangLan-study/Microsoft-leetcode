class Solution {
    public int minMoves(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        
        List<Integer> onesIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                onesIndices.add(i);
            }
        }
        
        int totalOnes = onesIndices.size();
        int[] preSum = new int[totalOnes];
        preSum[0] = (onesIndices.get(0));
        for (int i = 1; i < totalOnes; i++) {
            preSum[i] = preSum[i - 1] + onesIndices.get(i);
        }
        
        int result = Integer.MAX_VALUE;
        int radius = (k - 1) / 2;
        for(int i = radius; i < totalOnes - k / 2; i++) {
            int right = k % 2 == 0 ? preSum[i + radius + 1] - preSum[i] - onesIndices.get(i) :       // even case
                                   preSum[i + radius] - preSum[i];                                  // odd case
            int left =  (i == 0 ? 0 : preSum[i - 1]) - (i - radius == 0 ? 0 : preSum[i - radius - 1]);
            int save = (radius + 1) * radius + (k % 2 == 0 ? radius + 1 : 0);
            result = Math.min(result, right - left - save);
        }
        return result;
    }
}