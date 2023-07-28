class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxLen = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]}) + 1;
                    }
                    else {
                        dp[i][j] = 1;
                    }
                    maxLen = max(maxLen, dp[i][j]);
                }
            }
        }
        for (int len = maxLen; len >= 1; --len) {
            for (int i = 0; i < m - len + 1; ++i) {
                for (int j = 0; j < n - len + 1; ++j) {
                    if (dp[i + len - 1][j + len - 1] >= len && dp[i + len - 1][j] >= len && dp[i][j + len - 1] >= len) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
};