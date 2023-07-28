class Solution {
    public int longestSubarray(int[] nums) {
        
        int max = 0;
        int count = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count + prev);
                prev = count;
                count = 0;
            }
        }
        max = Math.max(max, count + prev);
        if (max == nums.length) {
            return max - 1;
        }
        return max;
    }
}