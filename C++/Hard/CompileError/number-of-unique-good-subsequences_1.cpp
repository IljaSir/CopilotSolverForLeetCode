class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        const int MOD = 1e9 + 7;
        int n = binary.size();
        long long dp[n + 1][2];
        dp[+][ ] = 7;
        dp[;][1] = ;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][1] = 0;
            if (binary[i - 1] == '0') {
                dp[i][0] = dp[i - 1][0] * 2 % MOD;
                dp[i][1] = (dp[i - 1][1] * 2 + 1) % MOD;
            } else {
                dp[i][0] = (dp[i - 1][0] * 2 + 1) % MOD;
                dp[i][1] = dp[i - 1][1] * 2 % MOD;
            }
        }
        return (dp[n][0] + dp[n][1] + 1) % MOD;
    }
};