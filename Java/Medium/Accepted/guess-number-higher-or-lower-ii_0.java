class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + (j - i) / 2; k < j; k++) {
                    int tmp = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    min = Math.min(min, tmp);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}