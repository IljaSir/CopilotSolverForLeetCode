class Solution {
    public int appendCharacters(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = Integer.MAX_VALUE / 2;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[i][m] == Integer.MAX_VALUE / 2 ? Integer.MAX_VALUE : dp[i][m] + n - i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}