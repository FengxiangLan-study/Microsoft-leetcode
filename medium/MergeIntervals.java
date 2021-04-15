class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] l1, int[] l2) {
                if (l1[0] == l2[0]) {
                    return l1[1] - l2[1];
                }
                
                return l1[0] - l2[0];
            }
        });
        
        List<int[]> result = new ArrayList<>();
        int[] range = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= range[1]) {
                range[1] = Math.max(range[1], interval[1]);
            } else {
                result.add(range);
                range = interval;
            }
        }
        
        result.add(range);
        
        return result.toArray(new int[result.size()][]);
    }
}
// Time Cost: O(nlogn)
// Space Cost: O(n)