class Solution {
    public String modifyString(String s) {
        char[] array = s.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '?') {
                char letter;
                for (letter = 'a'; letter <= 'z'; letter++) {
                    if (canUse(letter, i, array)) {
                        array[i] = letter;
                        break;
                    }
                }
            }
        }
        return new String(array);
    }
    
    private boolean canUse(char letter, int index, char[] array) {
        if (index == 0) {
            return array.length == 1 || array[index + 1] != letter;
        }
        
        if (index == array.length - 1) {
            return array.length == 1 || array[index - 1] != letter;
        }
        
        return array[index - 1] != letter && array[index + 1] != letter;
    }
    
}
// Time Cost: O(n)
// Space Cost: O(n)