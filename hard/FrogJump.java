class Solution {
    public boolean canCross(int[] stones) {
        // dp[i][j] = whether frog at position i could jump j steps
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        dp[0][1] = true;
        for (int i = 1; i < stones.length; i++) {
            boolean flag = false;
            
            for (int k = i - 1; k >= 0; k--) {
                int diff = stones[i] - stones[k];
                // since at position i, could at most jump i + 1, so diff must smaller than or equal than i
                if (diff > i) {
                    break;
                }
                
                if (dp[k][diff]) {
                    dp[i][diff - 1] = true;
                    dp[i][diff] = true;
                    dp[i][diff + 1] = true;
                    flag = true;
                }
            }
            
            if (i == stones.length - 1 && !flag) {
                return false;
            }
        }
        return true;
    }
}