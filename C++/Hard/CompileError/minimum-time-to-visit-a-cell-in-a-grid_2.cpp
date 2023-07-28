class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0});
        while (!pq.empty()) {
            auto [d, x, y] = pq.top(); pq.pop();
            if (d > dist[x][y]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nd = max(d, grid[nx][ny]);
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    pq.push({nd, nx, ny});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
};