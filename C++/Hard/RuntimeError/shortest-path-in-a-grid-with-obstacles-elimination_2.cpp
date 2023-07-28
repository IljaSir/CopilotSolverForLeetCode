class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        if (m == 1 && n == 1) return 0;
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k + 1, INT_MAX)));
        dp[0][0][0] = 0;
        int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            int x = q.front().first, y = q.front().second;
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] == 0) {
                    for (int j = 0; j <= k; j++) {
                        if (dp[x][y][j] + 1 < dp[nx][ny][j]) {
                            dp[nx][ny][j] = dp[x][y][j] + 1;
                            q.push({nx, ny});
                        }
                    }
                }
                else {
                    for (int j = 0; j < k; j++) {
                        if (dp[x][y][j] + 1 < dp[nx][ny][j + 1]) {
                            dp[nx][ny][j + 1] = dp[x][y][j] + 1;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= k; i++) {
            res = min(res, dp[m - 1][n - 1][i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};