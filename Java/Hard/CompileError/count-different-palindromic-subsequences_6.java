class Solution {
    public int countPalindromicSubsequences(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int[][] next = new int[n][4];
        int[][] prev = new int[n][4];
        int mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            Arrays.fill(next[i], n);
            Arrays.fill(prev[i], -1);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (i < n - 1) {
                    next[i][j] = next[i + 1][j];
                }
            }
            next[i][s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (i > 0) {
                    prev[i][j] = prev[i - 1][j];
                }
            }
            prev[i][s.charAt(i) - 'a'] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char c = (char)('a' + k);
                    if (i == j) {
                        if (s.charAt(i) == c) {
                            dp[i][j] = 1;
                        }
                        else {
                            dp[i][j] = 0;
                        }
                    }
                    else if (s.charAt(i) != c) {
                        dp[i][j] = dp[i + 1][j];
                    }
                    else if (s.charAt(j) != c) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    else {
                        int ni = next[i][k];
                        int pj = prev[j][k];
                        if (ni + 1 < pj) {
                            dp[i][j] = dp[ni + 1][pj - 1] * 2 % mod;
                        }
                        else if (ni + 1 == pj) {
                            dp[i][j] =
    }
}