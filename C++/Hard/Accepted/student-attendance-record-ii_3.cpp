class Solution {
public:
    int checkRecord(int n) {
        
        int mod = 1000000007;
        int64_t dp[n + 1][2][3];
        memset(dp, 0, sizeof(dp));
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // ending with P
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % mod;
                }
            }
            // ending with A
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % mod;
            }
            // ending with L
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                }
            }
        }
        int64_t ans = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                ans = (ans + dp[n][j][k]) % mod;
            }
        }
        return ans;
    }
};