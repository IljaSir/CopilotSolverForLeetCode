class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) {
            return 1;
        }
        if (primeFactors == 2) {
            return 2;
        }
        if (primeFactors == 3) {
            return 3;
        }
        long mod = 1000000007;
        long[] dp = new long[primeFactors + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= primeFactors; i++) {
            dp[i] = Math.max(dp[i], (dp[i - 1] * 1) % mod);
            dp[i] = Math.max(dp[i], (dp[i - 2] * 2) % mod);
            dp[i] = Math.max(dp[i], (dp[i - 3] * 3) % mod);
        }
        return (int) dp[primeFactors];
    }
}