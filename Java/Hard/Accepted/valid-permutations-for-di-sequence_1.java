class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i - 1) == 'I') {
                    for (int k = j; k < i; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 1000000007;
                    }
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[n][i]) % 1000000007;
        }
        return ans;
    }
}