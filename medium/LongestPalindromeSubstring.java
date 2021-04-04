class Solution {
    public String longestPalindrome(String s) {
        // isPalindrome[i][j] = substring (i, j) is palindrome
        // base case:
        // 1. isPalindrome[i][i] = true; -> len = 1
        // 2. isPalindrome[i][i + 1] = s[i] == s[i + 1] ? true : false; -> len = 2;
        // 3. isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s[i] == s[j] len = j - i
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int maxLen = 0;
        int start = 0;
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            maxLen = 1;
        }
        
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
            if (isPalindrome[i][i + 1] == true) {
                maxLen = 2;
                start = i;
            }
        }
        
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    maxLen = k;
                    start = i;
                }
            }
        }
        
        return s.substring(start, maxLen + start);
        
    }
}