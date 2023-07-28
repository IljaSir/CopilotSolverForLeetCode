class Solution {
    public int numPermsDISequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'I') {
                int sum = 0;
                for (int j = 0; j <= n - i; j++) {
                    sum = (sum + dp[i - 1][j]) % 1000000007;
                    dp[i][j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = n - i; j >= 0; j--) {
                    sum = (sum + dp[i - 1][j + 1]) % 1000000007;
                    dp[i][j] = sum;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[n][i]) % 1000000007;
        }
        return sum;
    }
}