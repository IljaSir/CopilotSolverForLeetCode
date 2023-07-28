class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int MOD = 1000000007;
        int m = evil.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        int[][] next = new int[m + 1][26];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < 26; j++) {
                String s = evil.substring(0, i) + (char)('a' + j);
                for (int k = Math.min(m, s.length()); k >= 0; k--) {
                    if (s.endsWith(evil.substring(0, k))) {
                        next[i][j] = k;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                int low = i == 0 ? s1.charAt(i) - 'a' : 0;
                int high = i == 0 ? s2.charAt(i) - 'a' : 25;
                for (int k = low; k <= high; k++) {
                    int nj = next[j][k];
                    dp[i + 1][nj] = (dp[i + 1][nj] + dp[i][j]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }
        return ans;
    }
}