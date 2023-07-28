class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        int MOD = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(6, 0));
        vector<int> sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else {
                    for (int k = 0; k < 6; ++k) {
                        if (j == k) {
                            if (rollMax[j] > 1) {
                                dp[i][j] += sum[i - 2];
                                if (i - rollMax[j] - 1 >= 0) {
                                    dp[i][j] -= sum[i - rollMax[j] - 1];
                                }
                            }
                        } else {
                            dp[i][j] += sum[i - 1];
                        }
                        dp[i][j] = (dp[i][j] + MOD) % MOD;
                    }
                }
                sum[i] = (sum[i] + dp[i][j]) % MOD;
            }
        }
        return sum[n];
    }
};