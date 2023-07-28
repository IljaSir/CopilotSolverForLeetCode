class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        vector<vector<int>> valid = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 1}, {1, 1, 0, 0}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        visited[0][0] = true;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && valid[grid[x][y] - 1][i] && valid[grid[nx][ny] - 1][(i + 2) % 4]) {
                    q.push({nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
};