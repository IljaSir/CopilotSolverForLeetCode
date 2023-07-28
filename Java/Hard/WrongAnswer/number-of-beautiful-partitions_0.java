class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        boolean[] primes = new boolean[10];
        primes[2] = true;
        primes[3] = true;
        primes[5] = true;
        primes[7] = true;
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i / minLength, k); j >= 1; j--) {
                int num = 0;
                for (int p = i; p >= 1 && i - p + 1 <= minLength; p--) {
                    num = num * 10 + s.charAt(p - 1) - '0';
                    if (num > 0 && num < 10) {
                        if (primes[num] && s.charAt(i - 1) % 2 == 0) {
                            dp[i][j] = (dp[i][j] + dp[p - 1][j - 1]) % mod;
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
}