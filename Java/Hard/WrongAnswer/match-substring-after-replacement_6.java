class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                    if (dp[i - 1][j] == 1) {
                        dp[i][j] = 1;
                    } else {
                        for (char[] mapping : mappings) {
                            if (s.charAt(i - 1) == mapping[0] && sub.charAt(j - 1) == mapping[1]) {
                                if (dp[i - 1][j - 1] == 1) {
                                    dp[i][j] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m] == 1;
    }
}