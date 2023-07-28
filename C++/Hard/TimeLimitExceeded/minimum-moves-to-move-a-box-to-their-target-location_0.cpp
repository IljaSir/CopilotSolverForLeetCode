class Solution {
public:
    int minPushBox(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sx = 0, sy = 0, bx = 0, by = 0, tx = 0, ty = 0;
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
        queue<tuple<int, int, int, int>> q;
        q.push({sx, sy, bx, by});
        int ans = 0;
        int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [x, y, bx, by] = q.front();
                q.pop();
                if (bx == tx && by == ty) {
                    return ans;
                }
                for (int k = 0; k < 4; ++k) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                        continue;
                    }
                    int nbx = bx + dir[k][0];
                    int nby = by + dir[k][1];
                    if (nbx < 0 || nbx >= m || nby < 0 || nby >= n || grid[nbx][nby] == '#') {
                        continue;
                    }
                    if (nx == bx && ny == by) {
                        q.push({nbx, nby, bx, by});
                    } else {
                        q.push({nx, ny, bx, by});
                    }
                }
            }
            ++ans;
        }
        return -1;
    }
};