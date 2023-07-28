class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        queue<pair<int, int>> q;
        q.push({0, 0});
        dist[0][0] = 0;
        while (!q.empty()) {
            int i = q.front().first, j = q.front().second;
            q.pop();
            if (i > 0 && grid[i - 1][j] != 2 && dist[i - 1][j] > dist[i][j] + 1) {
                dist[i - 1][j] = dist[i][j] + 1;
                q.push({i - 1, j});
            }
            if (i < n - 1 && grid[i + 1][j] != 2 && dist[i + 1][j] > dist[i][j] + 1) {
                dist[i + 1][j] = dist[i][j] + 1;
                q.push({i + 1, j});
            }
            if (j > 0 && grid[i][j - 1] != 2 && dist[i][j - 1] > dist[i][j] + 1) {
                dist[i][j - 1] = dist[i][j] + 1;
                q.push({i, j - 1});
            }
            if (j < m - 1 && grid[i][j + 1] != 2 && dist[i][j + 1] > dist[i][j] + 1) {
                dist[i][j + 1] = dist[i][j] + 1;
                q.push({i, j + 1});
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    if (i > 0 && grid[i - 1][j] != 2 && dist[i - 1][j] > dist[i][j]) ++cnt;
                    if (i < n - 1 && grid[i + 1][j] != 2 && dist[i
    }
};