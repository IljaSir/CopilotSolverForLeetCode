class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        vector<vector<long>> dp(n, vector<long>(7, 0));
        for (int i = 0; i < 6; ++i) dp[0][i] = 1;
        dp[0][6] = 6;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 1; k <= rollMax[j]; ++k) {
                    if (i - k >= 0) {
                        dp[i][j] += (dp[i - k][6] - dp[i - k][j] + 1000000007) % 1000000007;
                    }
                }
                dp[i][6] = (dp[i][6] + dp[i][j]) % 1000000007;
            }
        }
        return dp[n - 1][6];
    }
};