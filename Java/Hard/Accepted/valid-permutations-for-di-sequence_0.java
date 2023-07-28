class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i - 1) == 'D') {
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
        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[n][j]) % 1000000007;
        }
        return ans;
    }
}