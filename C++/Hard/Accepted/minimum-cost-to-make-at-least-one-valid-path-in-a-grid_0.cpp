class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            int x = q.front().first, y = q.front().second;
            q.pop();
            int c = cost[x][y];
            int dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0};
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nc = c + (i + 1 == grid[x][y] ? 0 : 1);
                    if (nc < cost[nx][ny]) {
                        cost[nx][ny] = nc;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
};