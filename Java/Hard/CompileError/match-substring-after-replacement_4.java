class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                char c = s.charAt(i - 1);
                char d = sub.charAt(j - 1);
                if (c == d) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    for (char[] mapping : mappings) {
                        if (mapping[0].charAt(0) == d) {
                            if (mapping[1].charAt(0) == c) {
                                dp[i][j] = dp[i - 1][j - 1];
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m] == 1;
    }
}