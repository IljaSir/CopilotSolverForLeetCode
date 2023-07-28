class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], sum[i] - sum[l]));
                }
            }
        }
        return dp[n][k];
    }
}