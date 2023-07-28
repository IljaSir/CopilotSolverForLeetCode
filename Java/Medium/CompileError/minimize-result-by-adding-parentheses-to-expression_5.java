class Solution {
    public String minimizeResult(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = expression.charAt(i) - '0';
        }
        for (int len = 1; len < n; len += 2) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                for (int k = i; k < j; k += 2) {
                    int left = dp[i][k];
                    int right = dp[k + 2][j];
                    int val = expression.charAt(k + 1) == '+' ? left + right : left * right;
                    if (val < dp[i][j]) {
                        dp[i][j] = val;
                    }
                }
            }
        }
        String[][] ans = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], "");
        }
        for (int i = 0; i < n; i++) {
            ans[i][i] = String.valueOf(expression.charAt(i));
        }
        for (int len = 1; len < n; len += 2) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                for (int k = i; k < j; k += 2) {
                    int left = dp[i][k];
                    int right = dp[k + 2][j];
                    int val = expression.charAt(k + 1) == '+' ? left + right : left * right;
                    if (val == dp[i][j]) {
                        String l = ans[i][k];
                        String r = ans[k + 2][j];
                        String s = expression.charAt(k + 1) == '+' ? l + "+" + r : l + "*" + r;
                        if (expression.charAt(k + 1) == '+' && (l.length() > 1 || r.length() > 1)) {
                            s = "(" + s + ")";
                        }
                        if (s.length() < ans[i][j].length() || ans[i][j].length() == 0) {
                            ans[i][j] =
    }
}