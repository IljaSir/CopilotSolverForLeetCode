class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                for (int k = i + 1; k <= j; ++k) {
                    if (isOverlap(bombs[i], bombs[k])) {
                        dp[i][j] = max(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};