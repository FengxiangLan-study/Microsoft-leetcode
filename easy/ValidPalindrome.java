class Solution {
    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (!isLetterOrDigit(array[left])) {
                left++;
            } else if (!isLetterOrDigit(array[right])) {
                right--;
            } else if (array[left] != array[right]){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isLetterOrDigit(Character letter) {
        if (letter >= 'a' && letter <= 'z' || (letter >= '0' && letter <= '9')) {
            return true;
        }
        return false;
    }
}