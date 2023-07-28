class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max + nums[i]);
            min = Math.min(nums[i], min + nums[i]);
            maxSum = Math.max(maxSum, max);
            minSum = Math.min(minSum, min);
        }
        if (maxSum > 0) {
            return Math.max(maxSum, sum - minSum);
        } else {
            return maxSum;
        }
    }
}