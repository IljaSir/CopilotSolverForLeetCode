class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = i; k < j; ++k) {
                    int left = sum[k + 1] - sum[i];
                    int right = sum[j + 1] - sum[k + 1];
                    if (left < right) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + right);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};