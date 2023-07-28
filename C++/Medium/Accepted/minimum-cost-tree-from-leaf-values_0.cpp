class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int n = arr.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = arr[i] * arr[i + 1];
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + *max_element(arr.begin() + i, arr.begin() + k + 1) * *max_element(arr.begin() + k + 1, arr.begin() + j + 1));
                }
            }
        }
        return dp[0][n - 1];
    }
};