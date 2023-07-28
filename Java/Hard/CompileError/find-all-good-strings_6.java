class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int m = evil.length();
        int[] dp = new int[n + 1];
        int[] pre = new int[n + 1];
        int[][] next = new int[m + 1][26];
        int[][] fail = new int[m + 1][26];
        int mod = 1000000007;
        for (int i = 0; i < 26; i++) {
            next[0][i] = 0;
            fail[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 26; j++) {
                fail[i][j] = fail[next[i - 1][j]][j];
            }
            fail[i][evil.charAt(i - 1) - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i - 1][j];
            }
            next[i][evil.charAt(i - 1) - 'a'] = i;
        }
        dp[0] = 1;
        pre[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                int cur = next[fail[i - 1][j]][j];
                dp[i] += pre[i - 1] - (cur == m ? pre[i - m - 1] : 0);
            }
            dp[i] %= mod;
            dp[i] += mod;
            dp[i] %= mod;
            pre[i] = pre[i - 1] + dp[i];
            pre[i] %= mod;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = i == 0 ? 1 : 0;
            int end = s1.charAt(i) - 'a';
            for (int j = start; j < end; j++) {
                int cur = next[fail[i][j]][j];
                ans += pre[n - i - 1] - (cur == m ? pre[n - i - m - 1] : 0);
                ans %= mod;
                ans += mod;
    }
}