class Solution {
    public int minDistance(String word1, String word2) {
        // distance[i][j] represents the minimal number of actions to transform the first i letter of word1 and first j letter of word2
        // distance[i][j] = j when i = 0;
        // distance[i][j] = i when j = 0;
        // distance[i][j] = {
        //  1. distance[i - 1][j - 1] when word1[i - 1] == word2[j - 1]
        //  2. 1 + min(distance[i - 1][j], -> delete one
        //             distance[i][j - 1], -> insert one 
        //             distance[i][j - 1]) -> replace one
        // }
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = 1 + Math.min(distance[i - 1][j], Math.min(distance[i][j - 1], distance[i - 1][j - 1]));
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
// Time Cost: O(n * m)
// Space Cost: O(n * m)