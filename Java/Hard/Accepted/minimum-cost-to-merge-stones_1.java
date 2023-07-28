class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int m = k; m <= n; m++) {
            for (int i = 0; i + m <= n; i++) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int t = i; t < j; t += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][t] + dp[t + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += sums[j + 1] - sums[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}