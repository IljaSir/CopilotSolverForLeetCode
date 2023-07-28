class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = 1;
        }
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(scores, g, dp, 0, 0, 0);
    }

    private int dfs(int[] scores, int[][] g, int[][][] dp, int i, int j, int k) {
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int n = scores.length;
        int res = 0;
        if (i > 0 && g[i - 1][j] == 1 && g[i - 1][k] == 1) {
            res = Math.max(res, dfs(scores, g, dp, i - 1, j, k));
        }
        if (j > 0 && g[j - 1][i] == 1 && g[j - 1][k] == 1) {
            res = Math.max(res, dfs(scores, g, dp, i, j - 1, k));
        }
        if (k > 0 && g[k - 1][i] == 1 && g[k - 1][j] == 1) {
            res = Math.max(res, dfs(scores, g, dp, i, j, k - 1));
        }
        dp[i][j][k] = res + scores[i] + scores[j] + scores[k];
        return dp[i][j][k];
    }
}