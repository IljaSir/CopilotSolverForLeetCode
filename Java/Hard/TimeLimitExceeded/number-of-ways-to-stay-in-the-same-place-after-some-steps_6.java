class Solution {
    public int numWays(int steps, int arrLen) {
        
        int[] dp = new int[arrLen];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dp2 = new int[arrLen];
            for (int j = 0; j < arrLen; j++) {
                dp2[j] = dp[j];
                if (j > 0) {
                    dp2[j] = (dp2[j] + dp[j - 1]) % 1000000007;
                }
                if (j < arrLen - 1) {
                    dp2[j] = (dp2[j] + dp[j + 1]) % 1000000007;
                }
            }
            dp = dp2;
        }
        return dp[0];
    }
}