class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        vector<int> res;
        for (int q : queries) {
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 0; k < i; k++) {
                        for (int l = 0; l < j; l++) {
                            if (dp[i][j] - dp[i][l] - dp[k][j] + dp[k][l] <= q) {
                                ans = max(ans, (i - k) * (j - l));
                            }
                        }
                    }
                }
            }
            res.push_back(ans);
        }
        return res;
    }
};