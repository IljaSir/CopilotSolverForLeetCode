class Solution {
    public int minOperationsToFlip(String expression) {
        
s       int n = olve(int i, int j, String expression, int[][] dp, int[][] dp2) {
        if (i == j) {
            if (expression.charAt(i) == '1') return 0;
            return 1;
        }
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if (dp2[i][j] != Integer.MAX_VALUE) return dp2[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            char c = expression.charAt(k);
            if (c == '&') {
                ans = Math.min(ans, solve(i, k - 1, expression, dp, dp2) + solve(k + 1, j, expression, dp, dp2));
            } else if (c == '|') {
                ans = Math.min(ans, solve(i, k - 1, expression, dp, dp2) + solve(k + 1, j, expression, dp, dp2) + 1);
            } else if (c == '(') {
                int cnt = 0;
                int idx = k;
                while (idx < j) {
                    if (expression.charAt(idx) == '(') cnt++;
                    if (expression.charAt(idx) == ')') cnt--;
                    if (cnt == 0) break;
                    idx++;
                }
                ans = Math.min(ans, solve(k + 1, idx - 1, expression, dp, dp2));
                k = idx;
            }
        }
        return dp[i][j] = ans;
    }
}