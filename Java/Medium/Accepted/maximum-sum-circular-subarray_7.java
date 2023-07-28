class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curMax = 0;
        int curMin = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}