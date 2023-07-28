class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        vector<vector<int>> d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                queue<pair<int, int>> q;
                q.push({i, j});
                visited[i][j] = 1;
                while (!q.empty()) {
                    auto [x, y] = q.front(); q.pop();
                    for (auto& dir : d) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (grid[nx][ny] != grid[x][y]) continue;
                        if (visited[nx][ny] == 1) return true;
                        if (visited[nx][ny] == 2) continue;
                        visited[nx][ny] = 1;
                        q.push({nx, ny});
                    }
                }
                for (auto& q : visited) {
                    for (auto& v : q) {
                        if (v == 1) v = 2;
                    }
                }
            }
        }
        return false;
    }
};