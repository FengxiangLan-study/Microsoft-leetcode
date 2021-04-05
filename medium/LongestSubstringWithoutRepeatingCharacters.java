class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int slow = 0;
        int fast = 0;
        Set<Character> set = new HashSet<>();
        int global_max = 0;
        while (fast < s.length()) {
            char cur = s.charAt(fast);
            if (set.contains(cur)) {
                while (s.charAt(slow) != cur) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.remove(s.charAt(slow++));
            } else {
                set.add(cur);
                global_max = Math.max(global_max, fast - slow + 1);
                fast++;
            }
        }
        return global_max;
    }
}