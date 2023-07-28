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
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i + l <= n; ++i) {
                int j = i + l - 1;
                for (int k = i; k < j; ++k) {
                    int leftSum = prefixSum[k] - (i == 0 ? 0 : prefixSum[i - 1]);
                    int rightSum = prefixSum[j] - prefixSum[k];
                    if (leftSum < rightSum) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + leftSum);
                    } else if (leftSum > rightSum) {
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + rightSum);
                    } else {
                        dp[i][j] = max(dp[i][j], dp[i][k] + leftSum);
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + rightSum);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};