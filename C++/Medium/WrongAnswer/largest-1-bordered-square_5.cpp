class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                dp[i][j] = 1;
                if (i > 0 && j > 0) dp[i][j] += min({dp[i][j-1], dp[i-1][j], dp[i-1][j-1]});
                res = max(res, dp[i][j]);
            }
        }
        return res * res;
    }
};