class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] - nums[i] + nums[i - 1]);
        }
        return dp[n - 1];
    }
}