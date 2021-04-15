class Solution {
    public int[] sumZero(int n) {
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];
        int number = n;
        while (left < right) {
            result[left++] = number;
            result[right--] = -number;
            number--;
        }
        
        if (left == right) {
            result[left] = 0;
        }
        return result;
    }
}