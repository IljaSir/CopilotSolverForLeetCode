class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        dp[0][0] = 0;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (auto [dx, dy] : dir) {
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (grid[nx][ny] == 1) {
                        if (dp[x][y] + 1 < dp[nx][ny]) {
                            dp[nx][ny] = dp[x][y] + 1;
                            q.push({nx, ny});
                        }
                    } else {
                        if (dp[x][y] < dp[nx][ny]) {
                            dp[nx][ny] = dp[x][y];
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};