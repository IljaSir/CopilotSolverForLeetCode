class Solution {
    public int numPermsDISequence(String s) {
        
        int mod = 1_000_000_007;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'D') {
                int sum = 0;
                for (int j = n - 1; j >= 0; j--) {
                    sum = (sum + dp[i - 1][j]) % mod;
                    dp[i][j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = 0; j <= n; j++) {
                    sum = (sum + dp[i - 1][j]) % mod;
                    dp[i][j] = sum;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[n][i]) % mod;
        }
        return sum;
    }
}