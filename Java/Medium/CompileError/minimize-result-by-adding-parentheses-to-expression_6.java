class Solution {
    public String minimizeResult(String expression) {
        
        int n = expression.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '+') {
                continue;
            }
            dp[i][i][0] = dp[i][i][1] = c - '0';
        }
        for (int l = 2; l <= n; l += 2) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k += 2) {
                    int a = dp[i][k - 1][0], b = dp[i][k - 1][1];
                    int c = dp[k + 1][j][0], d = dp[k + 1][j][1];
                    if (expression.charAt(k) == '+') {
                        dp[i][j][0] = Math.min(dp[i][j][0], a + c);
                        dp[i][j][0] = Math.min(dp[i][j][0], a + d);
                        dp[i][j][0] = Math.min(dp[i][j][0], b + c);
                        dp[i][j][0] = Math.min(dp[i][j][0], b + d);
                        dp[i][j][1] = Math.max(dp[i][j][1], a + c);
                        dp[i][j][1] = Math.max(dp[i][j][1], a + d);
                        dp[i][j][1] = Math.max(dp[i][j][1], b + c);
                        dp[i][j][1] = Math.max(dp[i][j][1], b + d);
                    } else {
                        dp[i][j][0] = Math.min(dp[i][j][0], a - c);
                        dp[i][j][0] = Math.min(dp[i][j][0], a - d);
                        dp[i][j][0] = Math.min(dp[i][j][0], b - c);
                        dp[i][j][0] = Math.min(dp[i
    }
}