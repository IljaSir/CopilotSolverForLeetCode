class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        if (d > jobDifficulty.length) {
            return -1;
        }
        int[][] dp = new int[jobDifficulty.length][d];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < jobDifficulty.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            for (int j = i; j < jobDifficulty.length; j++) {
                int max = jobDifficulty[j];
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[j][i] = Math.min(dp[j][i], dp[k - 1][i - 1] + max);
                }
            }
        }
        return dp[jobDifficulty.length - 1][d - 1];
    }
}