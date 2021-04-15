class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftValues = map.getOrDefault(left, diffWaysToCompute(left));
                List<Integer> rightValues = map.getOrDefault(right, diffWaysToCompute(right));
                for (Integer leftValue : leftValues) {
                    for (Integer rightValue : rightValues) {
                        if (input.charAt(i) == '+') {
                            result.add(leftValue + rightValue);
                        } else if (input.charAt(i) == '-') {
                            result.add(leftValue - rightValue);
                        } else if (input.charAt(i) == '*') {
                            result.add(leftValue * rightValue);
                        }
                    }
                }
            }
        }
        
        if (result.isEmpty()) {
          result.add(Integer.parseInt(input));
        }
        map.put(input, result);
        return result;
    }
}