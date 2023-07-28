class Solution {
    public int countSubstrings(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][][] dp = new int[n][m][n+1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i > 0) dp[i][j][k] += dp[i-1][j][k];
                    if (j > 0) dp[i][j][k] += dp[i][j-1][k];
                    if (i > 0 && j > 0) dp[i][j][k] -= dp[i-1][j-1][k];
                    if (s.charAt(i) == t.charAt(j)) {
                        if (k > 0) dp[i][j][k] += dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] += 1;
                    }
                    if (k > 0) res += dp[i][j][k];
                }
            }
        }
        return res;
    }
}