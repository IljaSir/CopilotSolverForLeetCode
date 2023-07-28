class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int mod = 1000000007;
        int m = evil.length();
        int[][] dp = new int[n + 1][m];
        int[][] next = new int[m][26];
        for (int i = 0; i < m; i++) {
            Arrays.fill(next[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                if (i > 0 && evil.charAt(i) != 'a' + j) {
                    next[i][j] = next[i - 1][j];
                } else {
                    next[i][j] = i + (evil.charAt(i) == 'a' + j ? 1 : 0);
                }
            }
        }
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] * 26 % mod;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 26; k++) {
                    if (next[j][k] != -1) {
                        dp[i][next[j][k]] = (dp[i][next[j][k]] + dp[i - 1][j]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = (res + dp[n][i]) % mod;
        }
        int i = 0;
        for (; i < n; i++) {
            int j = s1.charAt(i) - 'a';
            int k = s2.charAt(i) - 'a';
            for (int p = 0; p < j; p++) {
                if (next[i][p] != -1) {
                    res = (res + sum[n - i - 1]) % mod;
                }
            }
            if (next[i][j] == -1) {
                break;
            } else {
                i = next[i][j];
            }
        }
        if (i
    }
}