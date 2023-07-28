class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        if (n == 1) return 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(s, 0, n-1, dp);
    }
    
    private int dfs(String s, int l, int r, int[][] dp) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];
        int res = 1 + dfs(s, l+1, r, dp);
        for (int i = l+1; i <= r; i++) {
            if (s.charAt(l) == s.charAt(i)) {
                res = Math.min(res, dfs(s, l+1, i-1, dp) + dfs(s, i, r, dp));
            }
        }
        dp[l][r] = res;
        return res;
    }
}