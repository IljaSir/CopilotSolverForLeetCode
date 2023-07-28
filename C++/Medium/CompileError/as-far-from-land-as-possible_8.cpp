class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int maxDist = -1;
        vector<vector<int>> dist(n, vector<int>(m, -1));
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    q.push({i, j});
                }
            }
        }
        if (q.size() == n * m) {
            return -1;
        }
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (auto [dx, dy] : dir) {
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    maxDist = max(maxDist, dist[nx][ny]);
                    q.push({nx, ny});
                }
            }
        }
        return maxDist;
    }
};