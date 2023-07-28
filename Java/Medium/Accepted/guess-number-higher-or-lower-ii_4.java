class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k - 1 >= i ? dp[i][k - 1] : 0;
                    int right = k + 1 <= j ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(left, right));
                }
            }
        }
        return dp[1][n];
    }
}