class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        
        int m = heightMap.size();
        int n = heightMap[0].size();
        int ans = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<vector<int>> dirs{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
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
        while (!pq.empty()) {
            auto [height, index] = pq.top();
            pq.pop();
            int x = index / n;
            int y = index % n;
            for (auto& dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    ans += max(0, height - heightMap[newX][newY]);
                    pq.push({max(height, heightMap[newX][newY]), newX * n + newY});
                }
            }
        }
        return ans;
    }
};