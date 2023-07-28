class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = dp[i - 1][j];
                if (j > 0) {
                    x = min(x, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    x = min(x, dp[i - 1][j + 1]);
                }
                dp[i][j] = x + matrix[i][j];
            }
        }
        int ans = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans;
    }
};