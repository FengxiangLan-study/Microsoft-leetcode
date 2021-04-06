class Solution {
    public int[][] generateMatrix(int n) {
        int[] number = { 1 };
        int[][] result = new int[n][n];
        generateMatrix(result, 0, n, number);
        return result;
    }
    
    private void generateMatrix(int[][] result, int start, int size, int[] number) {
        if (size == 0) {
            return;
        }
        
        if (size == 1) {
            result[start][start] = number[0];
            return;
        }
        
        for (int i = 0; i < size - 1; i++) {
            result[start][start + i] = number[0]++;
        }
        
        for (int i = 0; i < size - 1; i++) {
            result[start + i][start + size - 1] = number[0]++;
        }
        
        for (int i = size - 1; i >= 1; i--) {
            result[start + size - 1][start + i] = number[0]++;
        }
        
        for (int i = size - 1; i >= 1; i--) {
            result[start + i][start] = number[0]++;
        }
        
        generateMatrix(result, start + 1, size - 2, number);       
    }
}
// Time Cost: O(n * m)
// Space Cost: O(n * m)