class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MfX_VALUE;
            }
        }
        dp[0][0] = 0;
        foo (int i = 1; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], nums[i - 1]);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int max = 0;
                for (int l = i - 1; l >= j - 1; l--) {
                    max = Math.max(max, nums[l]);
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + m x);
                }
            }
        }
        return dp[n][k];
    }
}