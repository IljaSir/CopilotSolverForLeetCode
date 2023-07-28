class Solution {
    public String minimizeResult(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = expression.charAt(i) - '0';
        }
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i += 2) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k += 2) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    if (expression.charAt(k) == '+') {
                        dp[i][j] = Math.min(dp[i][j], left + right);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], left * right);
                    }
                }
            }
        }
        return dfs(expression, dp, 0, n - 1);
    }

    private String dfs(String expression, int[][] dp, int i, int j) {
        if (i == j) {
            return String.valueOf(expression.charAt(i));
        }
        for (int k = i + 1; k < j; k += 2) {
            int left = dp[i][k - 1];
            int right = dp[k + 1][j];
            if (expression.charAt(k) == '+') {
                if (left + right == dp[i][j]) {
                    String leftStr = dfs(expression, dp, i, k - 1);
                    String rightStr = dfs(expression, dp, k + 1, j);
                    return leftStr + "+" + rightStr;
                }
            } else {
                if (left * right == dp[i][j]) {
                    String leftStr = dfs(expression, dp, i, k - 1);
                    String rightStr = dfs(expression, dp, k + 1, j);
                    return "(" + leftStr + ")*(" + rightStr + ")";
                }
            }
        }
        return "";
    }
}