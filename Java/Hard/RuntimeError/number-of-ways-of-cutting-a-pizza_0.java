class Solution {
    public int ways(String[] pizza, int k) {
        
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[m][n][k];
        return dfs(sum, dp, 0, 0, k);
    }

    private int dfs(int[][] sum, int[][][] dp, int i, int j, int k) {
        int m = sum.length - 1;
        int n = sum[0].length - 1;
        if (sum[m][n] - sum[i][n] - sum[m][j] + sum[i][j] == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int x = i + 1; x < m; x++) {
            if (sum[x][n] - sum[i][n] - sum[x][j] + sum[i][j] > 0) {
                res = (res + dfs(sum, dp, x, j, k - 1)) % 1000000007;
            }
        }
        for (int y = j + 1; y < n; y++) {
            if (sum[m][y] - sum[i][y] - sum[m][j] + sum[i][j] > 0) {
                res = (res + dfs(sum, dp, i, y, k - 1)) % 1000000007;
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}