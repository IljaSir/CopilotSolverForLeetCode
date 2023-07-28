class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        // 0: up, 1: right, 2: down, 3: left
        int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; ++i) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int c = (grid[x][y] - 1 == i) ? cost[x][y] : cost[x][y] + 1;
                if (c < cost[nx][ny]) {
                    cost[nx][ny] = c;
                    q.push({nx, ny});
                }
            }
        }
        return cost[m - 1][n - 1];
    }
};