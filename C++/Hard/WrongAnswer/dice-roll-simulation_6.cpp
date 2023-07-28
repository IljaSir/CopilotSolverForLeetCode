class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        // dp[i][j][k] = number of sequences of length i, ending with j, with k consecutive j's
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(6, vector<int>(16, 0)));
        int MOD = 1e9 + 7;
        for (int j = 0; j < 6; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int j2 = 0; j2 < 6; j2++) {
                        if (j == j2) {
                            if (k < rollMax[j]) {
                                dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j2][k]) % MOD;
                            }
                        } else {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j2][k]) % MOD;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                ans = (ans + dp[n][j][k]) % MOD;
            }
        }
        return ans;
    }
};