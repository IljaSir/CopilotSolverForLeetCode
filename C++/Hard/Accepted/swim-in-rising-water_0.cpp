class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));
        dist[0][0] = grid[0][0];
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({grid[0][0], 0});
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            int x = u / n, y = u % n;
            if (x == n - 1 && y == n - 1) return d;
            for (auto dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                if (i >= 0 && i < n && j >= 0 && j < n) {
                    int v = i * n + j;
                    int nd = max(d, grid[i][j]);
                    if (nd < dist[i][j]) {
                        dist[i][j] = nd;
                        pq.push({nd, v});
                    }
                }
            }
        }
        return -1;
    }
};