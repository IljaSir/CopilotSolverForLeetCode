class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int i = 0;
        int j = 1;
        int len = nums.length;
        int max = 0;
        int min = 0;
        while (j < len) {
            if (Math.abs(nums[j] - nums[i]) > limit) {
                i++;
            } else {
                j++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}