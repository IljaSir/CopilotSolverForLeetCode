class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n][d];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i == 0 ? jobDifficulty[i] : Math.max(dp[i - 1][0], jobDifficulty[i]);
        }
        for (int j = 1; j < d; j++) {
            for (int i = j; i < n; i++) {
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