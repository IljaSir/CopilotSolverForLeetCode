class Solution {
public:
    int kInversePairs(int n, int k) {
        
        if (n == 1) return 1;
        vector<vector<long>> dp(n + 1, vector<long>(k + 1, 0));
        dp[2][0] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + 1000000007) % 1000000007;
            }
        }
        return dp[n][k];
    }
};