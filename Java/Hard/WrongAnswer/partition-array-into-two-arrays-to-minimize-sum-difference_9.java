class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                if (j < n / 2) {
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + nums[i]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= n / 2; j++) {
            ans = Math.min(ans, Math.abs(dp[n][j] - dp[n][n - j]));
        }
        return ans;
    }
}