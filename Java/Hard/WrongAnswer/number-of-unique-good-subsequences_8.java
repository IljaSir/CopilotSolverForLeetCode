class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int n = binary.length();
        int mod = 1000000007;
        int dp[] = new int[n];
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                dp[i] = (one + 1) % mod;
                zero = (zero + dp[i]) % mod;
            } else {
                dp[i] = (zero + 1) % mod;
                one = (one + dp[i]) % mod;
            }
        }
        return (zero + one + (binary.charAt(n - 1) == '0' ? 1 : 0)) % mod;
    }
}