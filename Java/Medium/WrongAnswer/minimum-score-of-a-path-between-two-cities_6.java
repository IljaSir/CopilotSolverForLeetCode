class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] road : roads) {
            int i = road[0] - 1;
            int j = road[1] - 1;
            dp[i][j] = road[2];
            dp[j][i] = road[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k], dp[k][j]));
                }
            }
        }
        return dp[0][n - 1];
    }
}