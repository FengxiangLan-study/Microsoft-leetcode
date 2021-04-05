class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = max sum end with i
        // dp[0] = nums[0]
        // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = sum < 0 ? num : sum + num;
            max = Math.max(sum, max);
        }
        return max;
    }
}