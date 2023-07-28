class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.size();
        int mod = 1000000007;
        int dp[n][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (corridor[i] == 'P') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
                dp[i][0] %= mod;
                dp[i][1] %= mod;
            }
        }
        return dp[n - 1][0];
    }
};