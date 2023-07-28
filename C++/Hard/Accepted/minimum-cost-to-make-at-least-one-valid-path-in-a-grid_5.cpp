class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; ++i) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int ncost = cost[x][y] + (grid[x][y] == i + 1 ? 0 : 1);
                    if (ncost < cost[nx][ny]) {
                        cost[nx][ny] = ncost;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
};