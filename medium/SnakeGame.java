class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Deque<int[]> snake = new LinkedList<>();
    boolean[][] board;
    int[][] food;
    int foodIndex = 0;
    int x = 0; 
    int y = 0;
    int score = 0;
    int row;
    int col;
    public SnakeGame(int width, int height, int[][] food) {
        this.board = new boolean[height][width];
        this.row = height;
        this.col = width;
        this.food = food;
        this.snake.offerFirst(new int[] {0, 0});
        board[0][0] = true;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return score;
        }
        
        if (direction.equals("U")) {
            x -= 1;
        } else if (direction.equals("D")) {
            x += 1;
        } else if (direction.equals("L")) {
            y -= 1;
        } else if (direction.equals("R")) {
            y += 1;
        }
        
        if (x < 0 || x >= row || y < 0 || y >= col ) {
            score = -1;
            return score;
        }
        
        if (foodIndex == food.length || x != food[foodIndex][0] || y != food[foodIndex][1]) {
            int[] tail = snake.pollLast();
            board[tail[0]][tail[1]] = false;
        } else {
            score++;
            foodIndex++;
        }
        
        if (board[x][y]) {
            score = -1;
            return score;
        } else {
            snake.offerFirst(new int[] {x, y});
            board[x][y] = true;
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */