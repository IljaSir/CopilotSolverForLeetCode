class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.size();
        int mod = 1e9+7;
        int dp[n+1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            if (corridor[i-1] == 'S') {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % mod;
                dp[i][1] = dp[i-1][0];
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }
        }
        return dp[n][0];
    }
};