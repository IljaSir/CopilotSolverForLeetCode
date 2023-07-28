class Solution {
    public int numWays(int steps, int arrLen) {
        
        int M = 1000000007;
        int n = Math.min(arrLen, steps + 1);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] ndp = new int[n];
            for (int j = 0; j < n; j++) {
                ndp[j] = dp[j];
                if (j > 0) {
                    ndp[j] = (ndp[j] + dp[j - 1]) % M;
                }
                if (j + 1 < n) {
                    ndp[j] = (ndp[j] + dp[j + 1]) % M;
                }
            }
            dp = ndp;
        }
        return dp[0];
    }
}