class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = getSet(wordDict);
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && canBreak[j] == true) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[canBreak.length - 1];
    }
    
    private Set<String> getSet(List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        
        return set;
    }
}