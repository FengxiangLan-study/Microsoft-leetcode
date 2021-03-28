class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // Contruct the Trie Tree
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character ch : word.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    helper(i, j, root, board, result);
                }
            }
        }
        return result; 
    }
    
    private void helper(int row, int col, TrieNode parent, char[][] board, List<String> result) {
        Character letter = board[row][col];
        TrieNode curNode = parent.children.get(letter);
        
        // check whehter there is any match
        if (curNode.word != null) {
            result.add(curNode.word);
            curNode.word = null;
        }
        
        // set this character as visited
        board[row][col] = '#';
        
        
        // Find four directions
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && curNode.children.containsKey(board[x][y])) {
                helper(x, y, curNode, board, result);
            }
        }
        
        // reset back
        board[row][col] = letter;
        
        // if remove leaf node
        if (curNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        public TrieNode() {
            this.children = new HashMap<>();
            this.word = word;
        }
    }
}