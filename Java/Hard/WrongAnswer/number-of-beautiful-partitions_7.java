class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int mod = 1000000007;
        int[] isPrime = new int[10];
        isPrime[2] = isPrime[3] = isPrime[5] = isPrime[7] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (i-j >= minLength && isPrime[s.charAt(j)-'0'] == 1 && isPrime[s.charAt(i-1)-'0'] == 0) {
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
        }
        return dp[n];
    }
}