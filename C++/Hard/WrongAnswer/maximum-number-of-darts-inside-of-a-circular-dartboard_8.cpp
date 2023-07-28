class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int dx = darts[i][0] - darts[j][0], dy = darts[i][1] - darts[j][1];
                if (dx * dx + dy * dy <= 4 * r * r) {
                    dp[i][j] = dp[j][i] = 1;
                }
            }
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = max(ans, dp[i][j] + 1);
            }
        }
        return ans;
    }
};