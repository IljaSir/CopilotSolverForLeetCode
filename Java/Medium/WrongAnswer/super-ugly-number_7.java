class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int[] candidates = new int[primes.length];
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                candidates[j] = dp[pointers[j]] * primes[j];
                minVal = Math.min(minVal, candidates[j]);
            }
            dp[i] = minVal;
            for (int j = 0; j < primes.length; j++) {
                if (candidates[j] == minVal) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}