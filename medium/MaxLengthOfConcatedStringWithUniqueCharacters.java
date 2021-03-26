class Solution {
    public int maxLength(List<String> arr) {
        int[] result = { 0 };
        dfs(arr, 0, "", result);
        return result[0];
    }
    
    private void dfs(List<String> arr, int index, String path, int[] result) {
        if (index >= arr.size()) {
            result[0] = Math.max(result[0], path.length());
            return;
        }
        
        String curStr = arr.get(index);
        // if not using this string
        dfs(arr, index + 1, path, result);
        // if using this string
        if (noDuplicate(path, curStr)) {
            // if we not using characters from current string before, add it
            dfs(arr, index + 1, path + curStr, result);
        } else {
            // else do not use it and update result
            result[0] = Math.max(result[0], path.length());
        }
    }
    
    private boolean noDuplicate(String path, String cur) {
        if (path.length() > 26 || cur.length() > 26) {
            return false;
        }
        int[] count = new int[26];
        for (char c : cur.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return false;
            }
            count[c - 'a']++;
        }
        for (char c: path.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return false;
            }
        }
        return true;
    }
}
// Time Cost: O(2^n)
// Space Cost: O(n)