class Solution {
    public String reverseWords(String s) {
        // first remove all leading, tailing and duplicate space by using slow fast points
        // slow = 0; fast = 0;
        // if s[fast] == ' '
        // 1. fast = 0, handle leading space
        // 2. s[fast - 1] = ' ' handle duplicate space
        // fast++;
        // else s[slow++] = s[fast++]
        
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        
        // currently if string has tailing space
        // slow - 1 will point to the first tailing space
        // so we need reverse array from 0 to slow - 2
        if (slow > 0 && array[slow - 1] == ' ') {
            return reverse(new String(array, 0, slow - 1));
        }
        return reverse(new String(array, 0, slow));
    }
    
    private String reverse(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] array = s.toCharArray();
        // reverse whole string
        reverse(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            // record start index of each word
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            // record end index of each word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }
    
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
// Time Cost: O(n)
// 1. remove leading, tailing and duplicate space, we visited all characters once, O(n)
// 2. reverse whole string, O(n)
// 3. reverse each word, O(n)
// Space Cost: O(n), we use a helper array