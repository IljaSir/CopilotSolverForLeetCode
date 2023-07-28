class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][start] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 1000; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    dp[i][j + nums[i - 1]] = Math.min(dp[i][j + nums[i - 1]], dp[i - 1][j]);
                    dp[i][j - nums[i - 1]] = Math.min(dp[i][j - nums[i - 1]], dp[i - 1][j]);
                    dp[i][j ^ nums[i - 1]] = Math.min(dp[i][j ^ nums[i - 1]], dp[i - 1][j] + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 1000; i++) {
            if (dp[n - 1][i] != Integer.MAX_VALUE) {
                res = Math.min(res, dp[n - 1][i] + Integer.bitCount(i ^ goal));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}