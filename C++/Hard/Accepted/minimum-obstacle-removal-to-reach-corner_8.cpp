class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        vector<int> dir = {0, 1, 0, -1, 0};
        q.push({0, 0});
        dp[0][0] = 0;
        while (!q.empty()) {
            int x = q.front().first, y = q.front().second;
            q.pop();
            for (int k = 0; k < 4; ++k) {
                int nx = x + dir[k], ny = y + dir[k + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int cost = dp[x][y] + grid[nx][ny];
                if (cost < dp[nx][ny]) {
                    dp[nx][ny] = cost;
                    q.push({nx, ny});
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};