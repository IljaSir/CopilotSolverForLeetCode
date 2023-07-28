class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int n = arr.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> maxs(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            maxs[i][i] = arr[i];
            for (int j = i + 1; j < n; ++j) {
                maxs[i][j] = max(maxs[i][j - 1], arr[j]);
            }
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                dp[i][j] = INT_MAX;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxs[i][k] * maxs[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
};