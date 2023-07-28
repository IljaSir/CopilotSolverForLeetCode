class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int N = grid.size();
        queue<pair<int, int>> q;
        int dirs[5] = {0, 1, 0, -1, 0};
        int color = 2;
        bool found = false;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, q, i, j, color);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto [x, y] = q.front(); q.pop();
                for (int k = 0; k < 4; ++k) {
                    int nx = x + dirs[k];
                    int ny = y + dirs[k+1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == color) continue;
                    if (grid[nx][ny] == 1) return step;
                    grid[nx][ny] = color;
                    q.push({nx, ny});
                }
            }
            ++step;
        }
        return -1;
    }
    void dfs(vector<vector<int>>& grid, queue<pair<int, int>>& q, int x, int y, int color) {
        int N = grid.size();
        int dirs[5] = {0, 1, 0, -1, 0};
        grid[x][y] = color;
        q.push({x, y});
        for (int k = 0; k < 4; ++k) {
            int nx = x + dirs[k];
            int ny = y + dirs[k+1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] != 1) continue;
            dfs(grid, q, nx, ny, color);
        }
    }
};