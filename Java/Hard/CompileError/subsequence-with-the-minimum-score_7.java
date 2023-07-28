class Solution {
    public int minimumScore(String s, String t) {
        
        int n = s.length(), m = t.length();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - 'a';
        }
        for (int i = 0; i < m; i++) {
            b[i] = t.charAt(i) - 'a';
        }
        int[][][] dp = new int[26][n + 1][m + 1];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            dp[i][0][0] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (a[j - 1] == i && b[k - 1] == i) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1] + 1);
                    }
                    if (a[j - 1] == i) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
                    }
                    if (b[k - 1] == i) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (dp[i][n][m] != Integer.MIN_VALUE) {
                ans = Math.max(ans, dp[i][n][m]);
            }
        }
    }
}