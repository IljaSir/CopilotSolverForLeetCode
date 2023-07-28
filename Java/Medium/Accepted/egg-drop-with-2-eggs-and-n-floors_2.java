class Solution {
    public int twoEggDrop(int n) {
        
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < 2; i++) {
            int x = 1;
            for (int j = 1; j <= n; j++) {
                while (x < j && Math.max(dp[i - 1][x - 1], dp[i][j - x]) > Math.max(dp[i - 1][x], dp[i][j - x - 1])) {
                    x++;
                }
                dp[i][j] = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
            }
        }
        return dp[1][n];
    }
}