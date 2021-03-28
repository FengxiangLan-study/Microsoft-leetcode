class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        helper(matrix, 0, 0, matrix.length, matrix[0].length, result);
        return result;
    }
    
    private void helper(int[][] matrix, int rIndex, int cIndex, int rLen, int cLen, List<Integer> result) {
        if (rLen <= 0 || cLen <= 0) {
            return;
        }
        
        if (rLen == 1 && cLen == 1) {
            result.add(matrix[rIndex][cIndex]);
            return;
        }
        
        if (rLen == 1) {
            for (int i = 0; i < cLen; i++) {
                result.add(matrix[rIndex][cIndex++]);
            }
            return;
        }
        
        if (cLen == 1) {
            for (int i = 0; i < rLen; i++) {
                result.add(matrix[rIndex++][cIndex]);
            }
            return;
        }
        
        // top-left to top-right
        for (int i = 0; i < cLen - 1; i++) {
            result.add(matrix[rIndex][cIndex++]);
        }
        
        // top-right to bottom-right
        for (int i = 0 ; i < rLen - 1; i++) {
            result.add(matrix[rIndex++][cIndex]);
        }
        
        // bottom-right to bottom-left
        for (int i = 0; i < cLen - 1; i++) {
            result.add(matrix[rIndex][cIndex--]);
        }
        
        // bottom-left to top-left
        for (int i = 0; i < rLen - 1; i++) {
            result.add(matrix[rIndex--][cIndex]);
        }
        
        helper(matrix, rIndex + 1, cIndex + 1, rLen - 2, cLen - 2, result);
    }
}

// Time Cost: we visit each element once, O(n * m)
// Space Cost: O(n * m)