class Solution {
    public int ways(String[] pizza, int k) {
        
        int m = pizza.length, n = pizza[0].length();
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[m][n][k + 1];
        for (int[][] d : dp) {
            for (int[] d1 : d) {
                Arrays.fill(d1, -1);
            }
        }
        return dfs(pizza, m, n, k, 0, 0, sum, dp);
    }
    private int dfs(String[] pizza, int m, int n, int k, int i, int j, int[][] sum, int[][][] dp) {
        if (sum[m][n] - sum[i][n] - sum[m][j] + sum[i][j] == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int a = i + 1; a < m; ++a) {
            if (sum[a][n] - sum[i][n] - sum[a][j] + sum[i][j] > 0) {
                res = (res + dfs(pizza, m, n, k - 1, a, j, sum, dp)) % 1000000007;
            }
        }
        for (int b = j + 1; b < n; ++b) {
            if (sum[m][b] - sum[i][b] - sum[m][j] + sum[i][j] > 0) {
                res = (res + dfs(pizza, m, n, k - 1, i, b, sum, dp)) % 1000000007;
            }
        }
        return dp
    }
}