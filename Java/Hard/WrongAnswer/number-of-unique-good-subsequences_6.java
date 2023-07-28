class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int[] dp = new int[2];
        dp[0] = 1;
        int mod = 1000000007;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                dp[1] = (dp[0] + dp[1]) % mod;
            } else {
                dp[0] = (dp[0] + dp[1]) % mod;
            }
        }
        return (dp[0] + dp[1] - 1 + mod) % mod;
    }
}