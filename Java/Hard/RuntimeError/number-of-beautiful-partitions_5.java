class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        int MOD = 1000000007;
        int[] primes = {2, 3, 5, 7};
        int[] nonPrimes = {1, 4, 6, 8, 9};
        for (int i = minLength; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = minLength; l <= i; l++) {
                    String sub = s.substring(i - l, i);
                    if (l < minLength) {
                        continue;
                    }
                    if (j == 1) {
                        if (isPrime(sub, primes, nonPrimes)) {
                            dp[i][j] = (dp[i][j] + 1) % MOD;
                        }
                    } else {
                        if (isPrime(sub, primes, nonPrimes)) {
                            dp[i][j] = (dp[i][j] + dp[i - l][j - 1]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
    private boolean isPrime(String s, int[] primes, int[] nonPrimes) {
        int num = Integer.parseInt(s);
        if (num == 1) {
            return false;
        }
        for (int prime : primes) {
            if (num == prime) {
                return true;
            }
        }
        for (int nonPrime : nonPrimes) {
            if (num == nonPrime) {
                return false;
            }
        }
        for (int prime : primes) {
            if (num % prime == 0) {
                return false;
            }
        }
        return true;
    }
}