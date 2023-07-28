class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = scores.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = scores[i];
        }
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            int[] cur = new int[] {ages[i], scores[i]};
            for (int j = 0; j < i; j++) {
                int[] prev = new int[] {ages[j], scores[j]};
                if (cur[0] >= prev[0] && cur[1] >= prev[1]) {
                    dp[i][j] = Math.max(dp[i][j], cur[1] + dp[j][j]);
                }
                if (cur[0] >= prev[0] && cur[1] <= prev[1]) {
                    dp[i][j] = Math.max(dp[i][j], prev[1] + dp[j][j]);
                }
                if (cur[0] <= prev[0] && cur[1] >= prev[1]) {
                    dp[i][j] = Math.max(dp[i][j], cur[1] + dp[j][j]);
                }
                if (cur[0] <= prev[0] && cur[1] <= prev[1]) {
                    dp[i][j] = Math.max(dp[i][j], prev[1] + dp[j][j]);
                }
                dp[i][i] = Math.max(dp[i][i], dp[i][j]);
            }
            ans = Math.max(ans, dp[i][i]);
        }
        return ans;
    }
}