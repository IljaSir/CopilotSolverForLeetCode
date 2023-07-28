class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n-1) % (k-1) > 0) return -1;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + stones[i];
        }
        int[][][] dp = new int[n][n][k+1];
        for (int m = k; m <= n; m++) {
            for (int i = 0; i <= n-m; i++) {
                int j = i + m - 1;
                dp[i][j][1] = prefix[j+1] - prefix[i];
                for (int t = 2; t <= k; t++) {
                    dp[i][j][t] = Integer.MAX_VALUE;
                    for (int p = i; p < j; p += k-1) {
                        dp[i][j][t] = Math.min(dp[i][j][t], dp[i][p][t-1] + dp[p+1][j][1]);
                    }
                }
            }
        }
        return dp[0][n-1][k];
    }
}