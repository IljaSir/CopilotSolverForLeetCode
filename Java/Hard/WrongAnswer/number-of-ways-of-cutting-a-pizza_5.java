class Solution {
    public int ways(String[] pizza, int k) {
        
        int mod = 1_000_000_007;
        int m = pizza.length, n = pizza[0].length();
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[m][n][k];
        return ways(pizza, k, 0, 0, sum, dp, mod);
    }
    
    private int ways(String[] pizza, int k, int x, int y, int[][] sum, int[][][] dp, int mod) {
        if (sum[x + 1][y + 1] == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (dp[x][y][k - 1] > 0) {
            return dp[x][y][k - 1];
        }
        int res = 0;
        for (int i = x + 1; i < pizza.length; i++) {
            if (sum[i + 1][y + 1] - sum[i + 1][x] - sum[y][i + 1] + sum[x][y] > 0) {
                res = (res + ways(pizza, k - 1, i, y, sum, dp, mod)) % mod;
            }
        }
        for (int i = y + 1; i < pizza[0].length(); i++) {
            if (sum[x + 1][i + 1] - sum[x + 1][y] - sum[x][i + 1] + sum[x][y] > 0) {
                res = (res + ways(pizza, k - 1, x, i, sum, dp, mod)) % mod;
            }
        }
        dp[x][y][k - 1] = res;
        return res;
    }
}