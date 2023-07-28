class Solution {
public:
    int minPushBox(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sx, sy, bx, by, tx, ty;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        vector<vector<vector<int>>> dist(m, vector<vector<int>>(n, vector<int>(4, -1)));
        queue<vector<int>> q;
        for (int i = 0; i < 4; ++i) {
            int x = bx + dirs[i][0];
            int y = by + dirs[i][1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#') {
                dist[bx][by][i] = 0;
                q.push({bx, by, i});
            }
        }
        while (!q.empty()) {
            auto t = q.front();
            q.pop();
            int x = t[0];
            int y = t[1];
            int d = t[2];
            int step = dist[x][y][d];
            if (x == tx && y == ty) {
                return step;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != '#') {
                    if (i == d) {
                        if (dist[nx][ny][d] == -1) {
                            dist[nx][ny][d] = step + 1;
                            q.push({nx, ny, d});
                        }
                    } else
    }
};