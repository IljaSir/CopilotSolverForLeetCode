class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j == 0 ? 1 : 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    char c1 = s.charAt(i - 1);
                    char c2 = sub.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        for (char[] mapping : mappings) {
                            if (mapping[0].charAt(0) == c2 && mapping[1].charAt(0) == c1) {
                                dp[i][j] = dp[i - 1][j - 1];
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m] == 1;
    }
}
    }
}