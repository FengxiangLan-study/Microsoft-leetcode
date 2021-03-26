class Solution {
    public int numIslands(char[][] grid) {
        // BST
        // if we could change original data
        // if grid[i][j] == 1, mark it as 0, then visit four directions
        // if equal to 1, put them to queue and set it to 0
        // until queue is empty, count++;
        
        // if could not change original data, we can use a helper metric visited[][] to record visited point
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir : directions) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (isValid(x, y, grid)) {
                                grid[x][y] = '0';
                                queue.offer(new int[] {x, y});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }
}
// Time Cost: O(m * n)
// Space Cost: O(min(m, n))