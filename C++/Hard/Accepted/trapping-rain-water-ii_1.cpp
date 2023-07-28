class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        
        int m = heightMap.size();
        int n = heightMap[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < m; ++i) {
            pq.push({heightMap[i][0], i * n});
            visited[i][0] = 1;
            pq.push({heightMap[i][n - 1], i * n + n - 1});
            visited[i][n - 1] = 1;
        }
        for (int j = 1; j < n - 1; ++j) {
            pq.push({heightMap[0][j], j});
            visited[0][j] = 1;
            pq.push({heightMap[m - 1][j], (m - 1) * n + j});
            visited[m - 1][j] = 1;
        }
        vector<int> dir = {-1, 0, 1, 0, -1};
        int ans = 0;
        while (!pq.empty()) {
            auto [h, idx] = pq.top();
            pq.pop();
            int i = idx / n;
            int j = idx % n;
            for (int k = 0; k < 4; ++k) {
                int ni = i + dir[k];
                int nj = j + dir[k + 1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    ans += max(0, h - heightMap[ni][nj]);
                    pq.push({max(h, heightMap[ni][nj]), ni * n + nj});
                    visited[ni][nj] = 1;
                }
            }
        }
        return ans;
    }
};