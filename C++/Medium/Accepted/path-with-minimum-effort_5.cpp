class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int m = heights.size(), n = heights[0].size();
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        vector<vector<int>> dirs{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto p = pq.top(); pq.pop();
            int x = p.second / n, y = p.second % n;
            if (x == m - 1 && y == n - 1) return p.first;
            for (auto& dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int d = max(p.first, abs(heights[x][y] - heights[nx][ny]));
                    if (d < dist[nx][ny]) {
                        dist[nx][ny] = d;
                        pq.push({d, nx * n + ny});
                    }
                }
            }
        }
        return -1;
    }
};