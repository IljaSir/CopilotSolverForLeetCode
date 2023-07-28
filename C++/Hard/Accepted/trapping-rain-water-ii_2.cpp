class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        
        int m = heightMap.size();
        int n = heightMap[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            q.push({heightMap[i][0], i * n});
            visited[i][0] = 1;
            q.push({heightMap[i][n - 1], i * n + n - 1});
            visited[i][n - 1] = 1;
        }
        for (int j = 1; j < n - 1; j++) {
            q.push({heightMap[0][j], j});
            visited[0][j] = 1;
            q.push({heightMap[m - 1][j], (m - 1) * n + j});
            visited[m - 1][j] = 1;
        }
        while (!q.empty()) {
            auto t = q.top();
            q.pop();
            int height = t.first;
            int x = t.second / n;
            int y = t.second % n;
            static const int dx[] = {-1, 1, 0, 0};
            static const int dy[] = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = 1;
                    if (heightMap[nx][ny] < height) {
                        ans += height - heightMap[nx][ny];
                        q.push({height, nx * n + ny});
                    } else {
                        q.push({heightMap[nx][ny], nx * n + ny});
                    }
                }
            }
        }
        return ans;
    }
};