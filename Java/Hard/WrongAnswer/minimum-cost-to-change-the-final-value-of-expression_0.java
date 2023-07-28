class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '1') {
                dp[i][i] = 0;
            } else if (expression.charAt(i) == '0') {
                dp[i][i] = 1;
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (expression.charAt(i) == '(' && expression.charAt(j) == ')') {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
                for (int k = i; k < j; k++) {
                    if (expression.charAt(k) == '&') {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    } else if (expression.charAt(k) == '|') {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + 1);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}