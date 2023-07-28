class Solution {
    public int ways(String[] pizza, int k) {
        
        int m = pizza.length, n = pizza[0].length();
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[m][n][k];
        return dfs(pizza, k - 1, 0, 0, sum, dp);
    }
    private int dfs(String[] pizza, int k, int i, int j, int[][] sum, int[][][] dp) {
        if (k == 0) {
            return sum[pizza.length][pizza[0].length()] - sum[i][pizza[0].length()] - sum[pizza.length][j] + sum[i][j] > 0 ? 1 : 0;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int p = i + 1; p < pizza.length; p++) {
            if (sum[p][pizza[0].length()] - sum[i][pizza[0].length()] - sum[p][j] + sum[i][j] > 0) {
                res = (res + dfs(pizza, k - 1, p, j, sum, dp)) % 1000000007;
            }
        }
        for (int p = j + 1; p < pizza[0].length(); p++) {
            if (sum[pizza.length][p] - sum[pizza.length][j] - sum[i][p] + sum[i][j] > 0) {
                res = (res + dfs(pizza, k - 1, i, p, sum, dp)) % 1000000007;
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}