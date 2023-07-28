class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        q.push({0, 0});
        dist[0][0] = 0;
        int ans = 0;
        while (!q.empty()) {
            int i = q.front().first;
            int j = q.front().second;
            q.pop();
            ans = max(ans, dist[i][j]);
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 2 && dist[ni][nj] > dist[i][j] + 1) {
                    dist[ni][nj] = dist[i][j] + 1;
                    q.push({ni, nj});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 2 && dist[ni][nj] > dist[i][j]) {
                            dist[ni][nj] = dist[i][j];
                        }
                    }
                }
            }
        }
        if (dist[m - 1][n - 1] == INT_MAX) {
            return -1;
        }
        return ans;
    }
};