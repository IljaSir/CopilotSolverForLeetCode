class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[0][0] = 0;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while (!pq.empty()) {
            auto [d, p] = pq.top();
            pq.pop();
            if (d > dist[p.first][p.second]) continue;
            for (int k = 0; k < 4; ++k) {
                int i = p.first + dirs[k], j = p.second + dirs[k + 1];
                if (i < 0 || i >= m || j < 0 || j >= n) continue;
                int cost = d + (k + 1 == grid[p.first][p.second] ? 0 : 1);
                if (cost < dist[i][j]) {
                    dist[i][j] = cost;
                    pq.push({cost, {i, j}});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
};