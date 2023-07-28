class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(i, k); ++j) {
                for (int p = 0; p < i; ++p) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p][j - 1], sum[i] - sum[p]));
                }
            }
        }];
    }
}