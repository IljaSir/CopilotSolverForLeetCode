class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i - k + 1];
            }
        }
        return maxSum / (double)k;
    }
}