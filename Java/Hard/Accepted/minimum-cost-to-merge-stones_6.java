class Solution {
    public int mergeStones(int[] stones, int k) {
        
        if ((stones.length - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] sum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        int[][][] dp = new int[stones.length][stones.length][k + 1];
        for (int len = k; len <= stones.length; len++) {
            for (int i = 0; i + len <= stones.length; i++) {
                int j = i + len - 1;
                for (int m = 2; m <= k; m++) {
                    dp[i][j][m] = Integer.MAX_VALUE;
                    for (int p = i; p < j; p += k - 1) {
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] + sum[j + 1] - sum[i];
            }
        }
        return dp[0][stones.length - 1][1];
    }
}