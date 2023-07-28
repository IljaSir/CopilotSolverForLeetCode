class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i > 0) {
                dp[i] += Math.max(0, max);
            }
            max = Math.max(max, dp[i]);
            if (i >= k) {
                max = Math.max(max, dp[i - k]);
            }
        }
        return max;
    }
}