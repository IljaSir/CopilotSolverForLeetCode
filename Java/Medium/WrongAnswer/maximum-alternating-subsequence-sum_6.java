class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        long res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            if (i % 2 == 0) {
                dp[i] += dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i], dp[i - 1] - nums[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}