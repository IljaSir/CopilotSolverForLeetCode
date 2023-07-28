class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n][d];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], jobDifficulty[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= Math.min(i, d - 1); j++) {
                int max = jobDifficulty[i];
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k >= j; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + max);
                }
            }
        }
        return dp[n - 1][d - 1];
    }
}