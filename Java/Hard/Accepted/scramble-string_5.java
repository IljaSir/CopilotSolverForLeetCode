class Solution {
    public boolean isScramble(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    for (int k = 1; k < l; k++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][l - k]) || (dp[i][j + l - k][k] && dp[i + k][j][l - k])) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}