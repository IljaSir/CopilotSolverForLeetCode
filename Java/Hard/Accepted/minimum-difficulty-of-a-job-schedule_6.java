class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[n][d];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], jobDifficulty[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < Math.min(i + 1, d); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int max = jobDifficulty[i];
                for (int k = i - 1; k >= j - 1; k--) {
                    max = Math.max(max, jobDifficulty[k + 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + max);
                }
            }
        }
        return dp[n - 1][d - 1];
    }
}