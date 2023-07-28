class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> prefixSum(n, 0);
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = prefixSum[j] - prefixSum[i] + stoneValue[i];
                for (int k = i; k < j; ++k) {
                    int left = prefixSum[k] - prefixSum[i] + stoneValue[i];
                    int right = sum - left;
                    if (left < right) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = max(dp[i][j], max(dp[i][k], dp[k + 1][j]) + left);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};