class Solution {
public:
    int colorTheGrid(int m, int n) {
        
        const int MOD = 1e9 + 7;
        int dp[1000][3][3][3][3];
        memset(dp, 0, sizeof(dp));
        dp[0][0][0][0][0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int a = 0; a < 3; ++a) {
                for (int b = 0; b < 3; ++b) {
                    for (int c = 0; c < 3; ++c) {
                        for (int d = 0; d < 3; ++d) {
                            if (a == b && b == c && c == d) continue;
                            for (int e = 0; e < 3; ++e) {
                                if (a == e || b == e) continue;
                                dp[i + 1][b][c][d][e] = (dp[i + 1][b][c][d][e] + dp[i][a][b][c][d]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int a = 0; a < 3; ++a) {
            for (int b = 0; b < 3; ++b) {
                for (int c = 0; c < 3; ++c) {
                    for (int d = 0; d < 3; ++d) {
                        ans = (ans + dp[n][a][b][c][d]) % MOD;
                    }
                }
            }
        }
        return ans;
    }
};