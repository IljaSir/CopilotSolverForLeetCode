class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[startRow][startColumn] = 1;
        int res = 0;
        int mod = 1e9 + 7;
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < maxMove; ++k) {
            vector<vector<int>> dp2(m, vector<int>(n, 0));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (auto &dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            res = (res + dp[i][j]) % mod;
                        } else {
                            dp2[x][y] = (dp2[x][y] + dp[i][j]) % mod;
                        }
                    }
                }
            }
            dp = dp2;
        }
        return res;
    }
};