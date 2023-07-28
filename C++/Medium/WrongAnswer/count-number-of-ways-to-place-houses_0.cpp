class Solution {
public:
    int countHousePlacements(int n) {
        
        int mod = 1e9 + 7;
        int dp[n + 1][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][0] * dp[i - 1][1]) % mod;
        }
        return dp[n][0];
    }
};