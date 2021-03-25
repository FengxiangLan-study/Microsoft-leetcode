class Solution {
    public int minCost(String s, int[] cost) {
        int max = cost[0];
        int sum = cost[0];
        int result = 0;
        char[] array = s.toCharArray();
        int duplicate = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] == duplicate) {
                sum += cost[i];
                max = Math.max(max, cost[i]);
            } else {
                result += (sum - max);
                sum = cost[i];
                max = cost[i];
                duplicate = array[i];
            }
        }
        result += (sum - max);
        return result;
    }
}

// Time Cost: O(n)
// Space Cost: O(n)