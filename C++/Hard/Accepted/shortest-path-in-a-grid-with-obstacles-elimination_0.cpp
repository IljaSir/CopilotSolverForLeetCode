class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(k+1, 0)));
        queue<vector<int>> q; // {x, y, k}
        q.push({0, 0, k});
        visited[0][0][k] = 1;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto t = q.front(); q.pop();
                int x = t[0], y = t[1], kk = t[2];
                if (x == m - 1 && y == n - 1) return step;
                for (auto dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1], nk = kk;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] == 1) --nk;
                    if (nk < 0 || visited[nx][ny][nk]) continue;
                    visited[nx][ny][nk] = 1;
                    q.push({nx, ny, nk});
                }
            }
            ++step;
        }
        return -1;
    }
};