class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newLine = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (String line : source) {
            int i = 0;
            char[] array = line.toCharArray();
            if (!inBlock) {
                newLine = new StringBuilder();
            }
            while (i < array.length) {
                if (!inBlock && i + 1 < array.length && array[i] == '/' && array[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < array.length && array[i] == '*' && array[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < array.length && array[i] == '/' && array[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    newLine.append(array[i]);
                }
                i++;
            }
            if (!inBlock && newLine.length() > 0) {
                result.add(new String(newLine));
            }
        }
        return result;
    }
}
// Time Cost: O(n) n is numbers of characters of source
// Space Cost: O(n)