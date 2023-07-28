class Solution {
    public long kSum(int[] nums, int k) {
        
            dp  ndp;
        }
        return dp[n];

=
        int n = nums.length;
        long[][] dp = new long[n][k + 1];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i - 1][1] + nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + nums[i]);
            }
        }
        return dp[dp.length - k];
    }
}