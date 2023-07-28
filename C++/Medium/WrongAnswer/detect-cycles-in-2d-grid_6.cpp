class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n));
        vector<vector<int>> dirs{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    char c = grid[i][j];
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    while (!q.empty()) {
                        auto [r, c] = q.front(); q.pop();
                        for (auto& dir : dirs) {
                            int x = r + dir[0], y = c + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == c && visited[x][y]) return true;
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == c && !visited[x][y]) {
                                visited[x][y] = true;
                                q.push({x, y});
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
};