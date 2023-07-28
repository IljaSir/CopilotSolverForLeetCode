class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            max = Math.max(max, maxSum);
            minSum = Math.min(minSum + nums[i], nums[i]);
            min = Math.min(min, minSum);
            sum += nums[i];
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }
}