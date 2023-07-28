class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int n = heights.size(), m = heights[0].size();
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        dist[0][0] = 0;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0});
        while (!pq.empty()) {
            auto [d, x, y] = pq.top(); pq.pop();
            if (d > dist[x][y]) continue;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nd = max(d, abs(heights[nx][ny] - heights[x][y]));
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    pq.push({nd, nx, ny});
                }
            }
        }
        return dist[n - 1][m - 1];
    }
};