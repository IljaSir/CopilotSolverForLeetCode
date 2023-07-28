class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long total = 0;
        for (int i = 0; i < k; i++) {
            total += nums[i];
        }
        long max = total;
        for (int i = k; i < nums.length; i++) {
            total += nums[i];
            total -= nums[i - k];
            max = Math.max(max, total);
        }
        return max;
    }
}