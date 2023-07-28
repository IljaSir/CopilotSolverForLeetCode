class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size() / 3;
        return max(maxSum(slices, n), maxSum(slices, n - 1));
    }
    int maxSum(vector<int>& slices, int n) {
        int m = slices.size();
        vector<vector<int>> dp(n + 1, vector<int>(m, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j < m; ++j) {
                dp[i][j] = max(dp[i][j - 1], (j >= 2 ? dp[i - 1][j - 2] : 0) + slices[j]);
            }
        }
        return dp[n][m - 1];
    }
};