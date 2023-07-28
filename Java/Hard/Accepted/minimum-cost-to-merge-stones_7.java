class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) presum[i + 1] = presum[i] + stones[i];
        int[][] dp = new int[n][n];
        for (int len = k; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += presum[j + 1] - presum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}