class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (n == 0) return -1;
        int m = grid[0].size();
        if (m == 0) return -1;
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.push({i, j});
                }
            }
        }
        if (q.size() == 0 || q.size() == n * m) return -1;
        int d = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x > 0 && grid[x - 1][y] == 0) {
                    grid[x - 1][y] = 1;
                    q.push({x - 1, y});
                }
                if (x < n - 1 && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    q.push({x + 1, y});
                }
                if (y > 0 && grid[x][y - 1] == 0) {
                    grid[x][y - 1] = 1;
                    q.push({x, y - 1});
                }
                if (y < m - 1 && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    q.push({x, y + 1});
                }
            }
            d++;
        }
        return d - 1;
    }
};