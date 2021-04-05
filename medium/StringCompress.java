class Solution {
    public int compress(char[] chars) {
        // use two pointer to find duplicate
        // slow = [0, slow) result, so slow will be next position need to add character
        // fast = current visited position
        // begin = first position of element that equal to fast
        // while first < len - 1
        // begin = fast and while fast < len - 1 and chars[fast] = chars[begin] fast++;
        // if fast - begin > 1 means chars[begin] has duplicate, we get number string from fast - begin
        // chars[slow++] = chars[begin];
        // for chr from number string, chars[slow++] = char of number
        
        int slow = 0;
        int fast = 0;
        while (fast < chars.length) {
            int begin = fast;
            while (fast < chars.length && chars[fast] == chars[begin]) {
                fast++;
            }
            
            chars[slow++] = chars[begin];
            if (fast - begin > 1) {
                List<Character> numberString = getString(fast - begin);
                for (int i = numberString.size() - 1; i >= 0; i--) {
                  chars[slow++] = numberString.get(i);
                }
            }
        }
        return slow;
    }
    
    private List<Character> getString(int number) {
        List<Character> result = new ArrayList<>();
        while (number > 0) {
          int i = number % 10;
          result.add((char)(i + '0')); 
              number = number / 10;
        }
        return result;
    }
}
// Time Cost: O(n)
// Space Cost: O(1)