class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (n == 0 || roads == null || roads.length == 0) {
            return 0;
        }
        
        int[] degrees = new int[n];
        boolean[][] connections = new boolean[n][n];
        for (int[] road : roads) {
            int i = road[0];
            int j = road[1];
            degrees[i]++;
            degrees[j]++;
            
            connections[i][j] = true;
            connections[j][i] = true;
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int degreeOne = degrees[i];   
                int degreeTwo = degrees[j];
                boolean connected = connections[i][j];
                int rank = connected ? degreeOne + degreeTwo - 1 : degreeOne + degreeTwo;
                result = Math.max(result, rank);
            }
        }
        return result;
    }
}

// Time Cost: O(n^2)
// Space Cost: O(n^2);