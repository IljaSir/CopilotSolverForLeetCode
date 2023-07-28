class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dist(n, vector<int>(m, 1e9));
        dist[0][0] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; ++i) {
                int nx = x + "2011"[i] - '1';
                int ny = y + "1120"[i] - '1';
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int d = max(dist[x][y], grid[nx][ny]);
                    if (d < dist[nx][ny]) {
                        dist[nx][ny] = d;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
};