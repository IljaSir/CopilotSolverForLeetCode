class Solution {
    public long kSum(int[] nums, int k) {
        
        long[][] n  = new long[k + 1][nums.length + 1];
        for (int j = 1; j <= nums.length; j++) {
            dp[1][j] = dp[1][j - 1] + nums[j - 1];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= nums- 1][k];;j++) {
                dp[i][j] = Math.max(dp[i][j 1], dp[i - 1][j - 1] + nums[j - 1]);
            }
        }
        return dp[][nums.length
    }
}