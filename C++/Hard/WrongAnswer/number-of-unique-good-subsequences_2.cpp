class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int mod = 1e9 + 7;
        int dp[n + 1][2];
        memset(dp, 0, sizeof(dp));
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            if (binary[i - 1] == '0') {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            }
        }
        return (dp[n][0] + dp[n][1] - 1 + mod) % mod;
    }
};