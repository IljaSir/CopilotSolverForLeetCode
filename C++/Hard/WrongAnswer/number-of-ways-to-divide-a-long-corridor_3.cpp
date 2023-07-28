class Solution {
public:
    int numberOfWays(string corridor) {
        
        int mod = 1e9+7;
        int n = corridor.length();
        vector<vector<long long>> dp(n+1, vector<long long>(2, 0));
        dp[0][0] = 1;
        for (int i = 0; i < n; ++i) {
            if (corridor[i] == 'S') {
                dp[i+1][0] = (dp[i+1][0] + dp[i][0] + dp[i][1]) % mod;
                dp[i+1][1] = dp[i][0];
            } else {
                dp[i+1][0] = dp[i][0];
                dp[i+1][1] = dp[i][1];
            }
        }
        return (dp[n][0] + dp[n][1]) % mod;
    }
};