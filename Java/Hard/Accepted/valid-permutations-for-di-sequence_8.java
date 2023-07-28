class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length();
        int MOD = 1000000007;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; ++i)
            dp[0][i] = 1;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'D') {
                int tot = 0;
                for (int j = i; j >= 0; --j) {
                    tot = (tot + dp[i][j]) % MOD;
                    dp[i+1][j] = tot;
                }
            } else {
                int tot = 0;
                for (int j = 0; j <= i; ++j) {
                    tot = (tot + dp[i][j]) % MOD;
                    dp[i+1][j+1] = tot;
                }
            }
        }

        int ans = 0;
        for (int x: dp[n])
            ans = (ans + x) % MOD;
        return ans;
    }
}