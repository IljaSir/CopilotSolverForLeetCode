class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        queue<pair<int, int>> q;
        q.push({0, 0});
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        visited[0][0] = true;
        vector<vector<int>> dx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        vector<vector<int>> dir = {{}, {0, 1}, {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == n - 1 && y == m - 1) return true;
            for (int d: dir[grid[x][y]]) {
                int nx = x + dx[d][0];
                int ny = y + dx[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
                if (grid[nx][ny] == 1 && (d == 0 || d == 1)) continue;
                if (grid[nx][ny] == 2 && (d == 2 || d == 3)) continue;
                if (grid[nx][ny] == 3 && (d == 0 || d == 3)) continue;
                if (grid[nx][ny] == 4 && (d == 1 || d == 3)) continue;
                if (grid[nx][ny] == 5 && (d == 0 || d == 2)) continue;
                if (grid[nx][ny] == 6 && (d == 1 || d == 2)) continue;
                visited[nx][ny] = true;
                q.push({nx, ny});
            }
        }
        return false;
    }
};