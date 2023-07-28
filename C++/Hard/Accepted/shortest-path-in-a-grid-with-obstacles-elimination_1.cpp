class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(k + 1, -1)));
        queue<vector<int>> q;
        q.push({0, 0, k});
        visited[0][0][k] = 0;
        while (!q.empty()) {
            auto t = q.front();
            q.pop();
            int x = t[0], y = t[1], remain = t[2];
            if (x == m - 1 && y == n - 1) {
                return visited[x][y][remain];
            }
            for (auto dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 1 && remain > 0 && visited[nx][ny][remain - 1] == -1) {
                    visited[nx][ny][remain - 1] = visited[x][y][remain] + 1;
                    q.push({nx, ny, remain - 1});
                } else if (grid[nx][ny] == 0 && visited[nx][ny][remain] == -1) {
                    visited[nx][ny][remain] = visited[x][y][remain] + 1;
                    q.push({nx, ny, remain});
                }
            }
        }
        return -1;
    }
};