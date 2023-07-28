class Solution {
    public int appendCharacters(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = -1;
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
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] != -1) {
                res = Math.min(res, i - dp[i][m]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}