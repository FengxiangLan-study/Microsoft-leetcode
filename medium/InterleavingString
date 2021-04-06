class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp[i][j] = whether s3.substring from 0 to i + j - 1 could be created by s1.substring from 0 to i - 1 and s2.subtring from 0 to j - 1
        // dp[0][0] = true
        // dp[0][j] = dp[0][j - 1] && s3[j - 1] == s2[j - 1]
        // dp[i][0] = dp[i - 1][0] && s3[i - 1] == s1[i - 1]
        // if s3[i + j - 1] == s1[i - 1], dp[i][j] = dp[i - 1][j]
        // if s3[i + j - 1] == s2[j - 1], dp[i][j] = dp[i - 1][j]
        // else dp[i][j] == false
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != (len1 + len2)) {
            return false;
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
                }
            }
        }
        
        return dp[len1][len2];
    }
}