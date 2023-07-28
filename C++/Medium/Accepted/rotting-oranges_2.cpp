class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int fresh = 0;
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.push({i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int ans = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                auto [x, y] = q.front();
                q.pop();
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    q.push({x - 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    q.push({x, y - 1});
                }
                if (x < m - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    q.push({x + 1, y});
                }
                if (y < n - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    q.push({x, y + 1});
                }
            }
            ans++;
        }
        return fresh == 0 ? ans - 1 : -1;
    }
};