class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int mod = 1000000007;
        int m = evil.length();
        int[][] dp = new int[n + 1][m];
        int[] next = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= m; j++) {
                if (evil.substring(0, j).equals(evil.substring(i - j + 1, i + 1))) {
                    next[i] = j;
                }
            }
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int min = s1.charAt(i - 1) - 'a';
            int max = s2.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j < min || j > max) {
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    int p = k;
                    while (p > 0 && evil.charAt(p) != 'a' + j) {
                        p = next[p - 1];
                    }
                    if (evil.charAt(p) == 'a' + j) {
                        p++;
                    }
                    dp[i][p] = (dp[i][p] + dp[i - 1][k]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = (res + dp[n][i]) % mod;
        }
        return res;
    }
}