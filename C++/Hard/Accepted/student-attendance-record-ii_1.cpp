class Solution {
public:
    int checkRecord(int n) {
        
        int M = 1000000007;
        vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(2, vector<int>(3)));
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % M;
                }
            }
            for (int k = 0; k < 3; ++k) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % M;
            }
            for (int j = 0; j < 2; ++j) {
                dp[i][j][1] = dp[i-1][j][0];
            }
            for (int j = 0; j < 2; ++j) {
                dp[i][j][2] = dp[i-1][j][1];
            }
        }
        int res = 0;
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 3; ++k) {
                res = (res + dp[n][j][k]) % M;
            }
        }
        return res;
    }
};