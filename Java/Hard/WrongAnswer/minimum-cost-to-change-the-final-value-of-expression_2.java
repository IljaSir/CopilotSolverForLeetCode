class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '0') {
                dp[i][i] = 1;
            } else if (c == '1') {
                dp[i][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int k = j + i;
                if (expression.charAt(j) == '(' && expression.charAt(k) == ')') {
                    dp[j][k] = dp[j + 1][k - 1];
                }
                for (int m = j; m < k; m++) {
                    if (expression.charAt(m) == '&') {
                        dp[j][k] = Math.min(dp[j][k], dp[j][m - 1] + dp[m + 1][k]);
                    } else if (expression.charAt(m) == '|') {
                        dp[j][k] = Math.min(dp[j][k], dp[j][m - 1] + dp[m + 1][k] + 1);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}