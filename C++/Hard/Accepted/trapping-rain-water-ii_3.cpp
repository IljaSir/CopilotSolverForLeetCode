class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        
        int m = heightMap.size(), n = heightMap[0].size();
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int res = 0;
        for (int i = 0; i < m; i++) {
            pq.push({heightMap[i][0], i, 0});
            pq.push({heightMap[i][n - 1], i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.push({heightMap[0][j], 0, j});
            pq.push({heightMap[m - 1][j], m - 1, j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        vector<vector<int>> dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!pq.empty()) {
            auto t = pq.top();
            pq.pop();
            for (auto dir : dirs) {
                int x = t[1] + dir[0], y = t[2] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                res += max(0, t[0] - heightMap[x][y]);
                pq.push({max(t[0], heightMap[x][y]), x, y});
                visited[x][y] = true;
            }
        }
        return res;
    }
};