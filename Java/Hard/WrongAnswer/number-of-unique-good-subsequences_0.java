class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int mod = 1000000007;
        int n = binary.length();
        long[] dp = new long[n];
        dp[0] = binary.charAt(0) == '0' ? 1 : 2;
        for (int i = 1; i < n; i++) {
            if (binary.charAt(i) == '0') {
                dp[i] = (dp[i - 1] * 2) % mod;
            } else {
                dp[i] = (dp[i - 1] * 2 + 1) % mod;
            }
        }
        return (int) dp[n - 1];
    }
}