class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int curNumber = 0;
        char operator = '+';
        for (int i = 0; i < len; i++) {
            char letter = s.charAt(i);
            if (letter >= '0' && letter <= '9') {
                curNumber = curNumber * 10 + (letter - '0');
            }
            if ((letter < '0' || letter > '9') && letter != ' ' || i == len - 1) {
                if (operator == '-') {
                    stack.offerFirst(-curNumber);
                } else if (operator == '+') {
                    stack.offerFirst(curNumber);
                } else if (operator == '*') {
                    stack.offerFirst(stack.pollFirst() * curNumber);
                } else if (operator == '/') {
                    stack.offerFirst(stack.pollFirst() / curNumber);
                }
                operator = letter;
                curNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollFirst();
        }
        return result;
    }
}

// Time Cost: O(n)
// Space Cost: O(n)