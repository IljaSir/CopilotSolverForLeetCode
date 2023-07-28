class Solution {
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = sum[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= Math.min(k, i + 1); j++) {
                for (int p = 0; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p][j - 1], sum[i] - sum[p]));
                }
            }
        }
        return dp[n - 1][k];
    }
}