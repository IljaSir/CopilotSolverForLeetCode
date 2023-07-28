class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> sum(n+1);
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + stoneValue[i];
        }
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = n-2; i >= 0; --i) {
            for (int j = i+1; j < n; ++j) {
                for (int k = i; k < j; ++k) {
                    int left = sum[k+1] - sum[i];
                    int right = sum[j+1] - sum[k+1];
                    if (left < right) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = max(dp[i][j], dp[k+1][j] + right);
                    } else {
                        dp[i][j] = max(dp[i][j], max(dp[i][k], dp[k+1][j]) + left);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
};