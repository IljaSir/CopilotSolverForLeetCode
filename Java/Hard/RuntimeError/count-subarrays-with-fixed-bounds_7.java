class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long count = 0;
        int left = 0, right = 0;
        int min = nums[0], max = nums[0];
        while (right < nums.length) {
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);
            while (min < minK) {
                min = Math.min(min, nums[++left]);
            }
            while (max > maxK) {
                max = Math.max(max, nums[++left]);
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}