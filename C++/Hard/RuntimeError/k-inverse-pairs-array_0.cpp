class Solution {
public:
    int kInversePairs(int n, int k) {
        
        if (k > n * (n - 1) / 2 || k < 0) return 0;
        if (k == 0 || k == n * (n - 1) / 2) return 1;
        
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        dp[2][0] = 1;
        dp[2][1] = 1;
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