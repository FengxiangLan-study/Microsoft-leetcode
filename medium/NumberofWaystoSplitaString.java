class Solution {
    long mod = (long)Math.pow(10, 9) + 7;
    public int numWays(String s) {
        if (s == null || s.length() <= 2) {
            return 0;
        }
        
        char[] array = s.toCharArray();
        int count = 0;
        for (char letter : array) {
            if (letter == '1') {
                count++;
            }
        }
        if (count == 0) {
            return (int)((((array.length - 1) % mod) * ((array.length - 2) % mod) / 2) % mod);
        }
        if (count % 3 != 0) {
            return 0;
        }
        
        int first = 0;
        int preffixIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '1') {
                first++;
                if (first == count / 3) {
                    preffixIndex = i;
                    first = 0;
                    break;
                }
            }
        }
        for (int i = preffixIndex + 1; i < array.length; i++) {
            if (array[i] == '0') {
                first++;
            } else {
                break;
            }
        }
        
        int end = 0;
        int suffixIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == '1') {
                end++;
                if (end == count / 3) {
                    suffixIndex = i;
                    end = 0;
                    break;
                }
            }
        }
        for (int i = suffixIndex - 1; i >= 0; i--) {
            if (array[i] == '0') {
                end++;
            } else {
                break;
            }
        }
        return (int)(((first + 1) % mod) * ((end + 1) % mod ) % mod);
    }
}