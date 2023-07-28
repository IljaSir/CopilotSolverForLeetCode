class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.push({i, j});
                    vis[i][j] = 1;
                }
            }
        }
        int ans = 0;
        while (!q.empty()) {
            int qs = q.size();
            for (int i = 0; i < qs; i++) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x - 1 >= 0 && !vis[x - 1][y]) {
                    q.push({x - 1, y});
                    vis[x - 1][y] = 1;
                }
                if (x + 1 < n && !vis[x + 1][y]) {
                    q.push({x + 1, y});
                    vis[x + 1][y] = 1;
                }
                if (y - 1 >= 0 && !vis[x][y - 1]) {
                    q.push({x, y - 1});
                    vis[x][y - 1] = 1;
                }
                if (y + 1 < m && !vis[x][y + 1]) {
                    q.push({x, y + 1});
                    vis[x][y + 1] = 1;
                }
            }
            if (!q.empty()) {
                ans++;
            }
        }
        if (ans == 0) {
            return -1;
        }
        return ans;
    }
};