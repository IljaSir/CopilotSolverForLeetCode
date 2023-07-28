class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> dx = {0, 0, 1, -1};
        vector<int> dy = {1, -1, 0, 0};
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            int x = q.front().first, y = q.front().second;
            q.pop();
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int ncost = cost[x][y] + (grid[x][y] - 1 == k ? 0 : 1);
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