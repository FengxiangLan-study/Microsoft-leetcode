class Solution {
    public List<String> letterCombinations(String digits) {
        // DFS
        // n level, n is length of digits
        // each level decides use one of the characters which current digit represents
        // base case, index = digits.length
        // recursive rule: 
        // for each characters of current digit
        //      using this one, then visit next digit
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = getMap();
        StringBuilder path = new StringBuilder("");
        helper(digits.toCharArray(), 0, path, map, result);
        return result;
    }
    
    private void helper(char[] digits, int index, StringBuilder path, Map<Character, char[]> map, List<String> result) {
        if (index == digits.length) {
            result.add(path.toString());
            return;
        }
        
        char[] letters = map.get(digits[index]);
        for (int i = 0; i < letters.length; i++) {
            path.append(letters[i]);
            helper(digits, index + 1, path, map, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    private Map<Character, char[]> getMap() {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        return map;
    }
}

// Time Cost: O(4^n * n)
// Space Cost: O(n)