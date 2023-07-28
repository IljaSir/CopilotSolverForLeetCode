class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int dx[4] = {1, 0, -1, 0};
        int dy[4] = {0, 1, 0, -1};
        queue<pair<int, int>> q;
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        q.push({0, 0});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int cost = dist[x][y];
                if (grid[x][y] != k + 1) cost++;
                if (dist[nx][ny] <= cost) continue;
                dist[nx][ny] = cost;
                q.push({nx, ny});
            }
        }
        return dist[m - 1][n - 1];
    }
};