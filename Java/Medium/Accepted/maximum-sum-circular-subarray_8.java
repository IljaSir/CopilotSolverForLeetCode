class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        
        for (int i = 1; i < n; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
            total += nums[i];
        }
        
        if (maxSum < 0)
            return maxSum;
        else
            return Math.max(maxSum, total - minSum);
    }
}