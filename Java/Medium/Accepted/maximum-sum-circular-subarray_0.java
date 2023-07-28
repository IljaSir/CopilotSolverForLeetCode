class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int total = 0, maxSum = Integer.MIN_VALUE, curMax = 0, minSum = Integer.MAX_VALUE, curMin = 0;
        for (int x: nums) {
            curMax = x + Math.max(curMax, 0);
            maxSum = Math.max(maxSum, curMax);
            curMin = x + Math.min(curMin, 0);
            minSum = Math.min(minSum, curMin);
            total += x;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}