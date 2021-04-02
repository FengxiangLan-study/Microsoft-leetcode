class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        for(int i = n - 1; i >= 0; i--) {
            if (isPalin(s, 0, i)) {
                return reverse(s, i) + s;
            }
        }
        return reverse(s, 0) + s;
    }
    
    private boolean isPalin(String s, int start, int end) {
        if (start == end) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private String reverse(String s, int start) {
        if (start == s.length() - 1) {
            return "";
        }
        
        char[] array = s.toCharArray();
        int end = array.length - 1;
        int i = start + 1;
        while (i < end) {
            char temp = array[i];
            array[i++] = array[end];
            array[end--] = temp;
        }
        
        return new String(array, start + 1, array.length - start - 1);
    }
}
// Time Cost: O(n^2)
// Space Cost: O(n)