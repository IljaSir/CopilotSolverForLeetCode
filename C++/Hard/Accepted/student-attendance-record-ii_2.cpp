class Solution {
public:
    int checkRecord(int n) {
        
        int M = 1000000007;
        long long dp[n+1][2][3];
        memset(dp, 0, sizeof(dp));
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % M;
                    if (j < 1) {
                        dp[i][j+1][0] = (dp[i][j+1][0] + dp[i-1][j][k]) % M;
                    }
                    if (k < 2) {
                        dp[i][j][k+1] = (dp[i][j][k+1] + dp[i-1][j][k]) % M;
                    }
                }
            }
        }
        long long ans = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                ans = (ans + dp[n][j][k]) % M;
            }
        }
        return ans;
    }
};