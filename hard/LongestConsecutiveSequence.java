class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int longest = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    length += 1;
                } else {
                    longest = Math.max(longest, length);
                    length = 1;
                }
            }
        }
        return Math.max(longest, length);
    }
}