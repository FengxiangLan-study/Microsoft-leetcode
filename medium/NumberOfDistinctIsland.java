class Solution {
    public int numDistinctIslands(int[][] grid) {
        // for (i, j) if grid[i][j] == 1, count++, put it to queue and set it to visited
        // for four directions, if grid[i + dir][j + dir] is valid (no visited and equals 1, put it to queue and set it to visited) until queue == empty;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<List<Integer>> shapes = new HashSet<>();
        // int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.offer(new int[] {i, j});
                    List<Integer> shape = new ArrayList<>();
                    shape.add(0);
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int[] dir = directions[k];
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                                grid[x][y] = 0;
                                queue.offer(new int[] {x, y});
                                shape.add(k + 1);
                            }
                        }
                        shape.add(0);
                    }
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }
}


class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        Set<List<Integer>> shapes = new HashSet<List<Integer>>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> shape = new ArrayList<Integer>();
                DFS(i, j, 0, shape, grid);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }
    
    private void DFS(int row, int col, int dir, List<Integer> shape, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        
        grid[row][col] = 0;
        shape.add(dir);
        DFS(row + 1, col, 1, shape, grid);
        DFS(row - 1, col, 2, shape, grid);
        DFS(row, col + 1, 3, shape, grid);
        DFS(row, col - 1, 4, shape, grid);
        shape.add(0);
    }
}