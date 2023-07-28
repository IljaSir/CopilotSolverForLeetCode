class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dist(n, vector<int>(n, -1));
        queue<pair<int, int>> q;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    q.push({i, j});
                }
            }
        }
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            int d = dist[x][y];
            ans = max(ans, d);
            if (x > 0 && dist[x - 1][y] == -1) {
                dist[x - 1][y] = d + 1;
                q.push({x - 1, y});
            }
            if (x < n - 1 && dist[x + 1][y] == -1) {
                dist[x + 1][y] = d + 1;
                q.push({x + 1, y});
            }
            if (y > 0 && dist[x][y - 1] == -1) {
                dist[x][y - 1] = d + 1;
                q.push({x, y - 1});
            }
            if (y < n - 1 && dist[x][y + 1] == -1) {
                dist[x][y + 1] = d + 1;
                q.push({x, y + 1});
            }
        }
        return ans;
    }
};