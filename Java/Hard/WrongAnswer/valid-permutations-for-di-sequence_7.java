class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length(), M = 1000000007;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) == 'I') {
                int sum = 0;
                for (int j = 0; j <= i; ++j) {
                    sum = (sum + dp[i - 1][j]) % M;
                    dp[i][j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = i; j >= 0; --j) {
                    sum = (sum + dp[i - 1][j]) % M;
                    dp[i][j] = sum;
                }
            }
        }
        return dp[n][0];
    }
}