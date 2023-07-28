class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        
        int MOD = 1000000007;
        int[] dp = new int[2];
        int one = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                dp[0] = (dp[0] + dp[1]) % MOD;
            } else {
                dp[1] = (dp[0] + dp[1] + 1) % MOD;
                one++;
            }
        }
        if (one == 0) {
            return 1;
        }
        return (dp[0] + dp[1] + 1) % MOD;
    }
}