class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return dfs(expression, 0, n - 1, dp);
    }
    private int dfs(String s, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != Integer.MAX_VALUE) {
            return dp[l][r];
        }
        if (l == r) {
            return s.charAt(l) == '0' ? 0 : 1;
        }
        int res = Integer.MAX_VALUE;
        int count = 0;
        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if (count == 0 && (c == '&' || c == '|')) {
                int left = dfs(s, l, i - 1, dp);
                int right = dfs(s, i + 1, r, dp);
                if (c == '&') {
                    res = Math.min(res, left + right);
                } else {
                    res = Math.min(res, Math.min(left, right) + 1);
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            res = dfs(s, l + 1, r - 1, dp);
        }
        dp[l][r] = res;
        return res;
    }
}