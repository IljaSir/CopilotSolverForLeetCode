class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        
        int m = heightMap.size();
        if (m == 0) return 0;
        int n = heightMap[0].size();
        if (n == 0) return 0;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < m; i++) {
            pq.push({heightMap[i][0], i * n});
            pq.push({heightMap[i][n - 1], i * n + n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.push({heightMap[0][j], j});
            pq.push({heightMap[m - 1][j], (m - 1) * n + j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int res = 0;
        while (!pq.empty()) {
            auto cur = pq.top();
            pq.pop();
            int i = cur.second / n;
            int j = cur.second % n;
            vector<pair<int, int>> dirs = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
            for (auto& dir : dirs) {
                int x = dir.first;
                int y = dir.second;
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += max(0, cur.first - heightMap[x][y]);
                    pq.push({max(cur.first, heightMap[x][y]), x * n + y});
                }
            }
        }
        return res;
    }
};