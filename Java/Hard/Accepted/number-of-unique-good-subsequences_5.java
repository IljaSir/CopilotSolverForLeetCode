class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int mod = 1000000007;
        long[] dp = new long[2];
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                dp[1] = (dp[0] + dp[1] + 1) % mod;
            } else {
                dp[0] = (dp[0] + dp[1]) % mod;
            }
        }
        return (int) ((dp[0] + dp[1] + (binary.indexOf('0') == -1 ? 0 : 1)) % mod);
    }
}