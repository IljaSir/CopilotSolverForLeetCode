class Solution {
    public int ways(String[] pizza, int k) {
        
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = 1000000007;
        int[][] apple = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    apple[i][j] = 1;
                }
                if (i > 0) {
                    apple[i][j] += apple[i - 1][j];
                }
                if (j > 0) {
                    apple[i][j] += apple[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    apple[i][j] -= apple[i - 1][j - 1];
                }
            }
        }
        int[][][] dp = new int[m][n][k];
        return dfs(0, 0, k - 1, apple, dp, mod);
    }

    public int dfs(int i, int j, int k, int[][] apple, int[][][] dp, int mod) {
        if (apple[i][j] == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }
        int m = apple.length;
        int n = apple[0].length;
        int total = apple[m - 1][n - 1];
        int count = 0;
        for (int x = i + 1; x < m; x++) {
            int cur = apple[x][n - 1];
            if (j > 0) {
                cur -= apple[x][j - 1];
            }
            if (total - cur > 0) {
                count = (count + dfs(x, j, k - 1, apple, dp, mod)) % mod;
            }
        }
        for (int y = j + 1; y < n; y++) {
            int cur = apple[m - 1][y];
            if (i > 0) {
                cur -= apple[i - 1][y];
            }
            if (total - cur
    }
}