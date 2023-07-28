class Solution {
    public int numOfWays(int n) {
        
        long[][] dp = new long[n][12];
        for (int i = 0; i < 12; i++) {
            dp[0][i] = 1;
        }
        int[][] colors = new int[][]{{1, 2}, {0, 2}, {0, 1}};
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                int k = j % 3;
                for (int c : colors[k]) {
                    dp[i][j] += dp[i - 1][c * 4 + k];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 12; i++) {
            ans += dp[n - 1][i];
            ans %= 1000000007;
        }
        return (int) ans;
    }
}