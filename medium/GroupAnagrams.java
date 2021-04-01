class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        Map<String, List> anagrams = new HashMap<String, List>();
        for (String s : strs) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }
            
            StringBuilder anagram = new StringBuilder();
            for (int count : counts) {
                anagram.append(',');
                anagram.append(count);
            }
            
            String key = anagram.toString();
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);
        }
        return new ArrayList(anagrams.values());
    }
}

// Time Cost: O(n * m)
// Space Cost: O(n * m) m is maximum length of string in strs