class Solution {
    public boolean canPermutePalindrome(String s) {
        // get a map which store the count of each characters
        // if string could form a palindrome, there are two possible conditions
        // 1. all characters have even count
        // 2. only one character has odd count
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        int oddCount = 0;
        for (int count : counts) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}

// Time Cost: O(n)
// Space Cost: O(n)