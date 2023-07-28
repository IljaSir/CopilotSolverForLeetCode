class Solution {
    public int numberOfCuts(int n) {
        
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        if (n == 5) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 4;
        for (int i = 6; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }
}