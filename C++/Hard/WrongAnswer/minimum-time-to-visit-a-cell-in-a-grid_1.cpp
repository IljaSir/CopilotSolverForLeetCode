class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        vector<int> dx = {0, 0, -1, 1};
        vector<int> dy = {-1, 1, 0, 0};
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int cost = max(dist[x][y], grid[nx][ny]);
                if (cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;
                    q.push({nx, ny});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
};