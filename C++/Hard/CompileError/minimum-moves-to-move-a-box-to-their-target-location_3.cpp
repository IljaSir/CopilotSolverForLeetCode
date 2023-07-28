class Solution {
public:
    int minPushBox(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sx, sy, bx, by, tx, ty;
        int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        vector<vector<vector<int>>> dist(m, vector<vector<int>>(n, vector<int>(m * n + 1, -1)));
        queue<tuple<int, int, int>> q;
        q.push({bx, by, 0});
        dist[bx][by][0] = 0;
        while (!q.empty()) {
            auto [x, y, d] = q.front();
            q.pop();
            if (x == tx && y == ty) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != '#') {
                    int nd = d + 1;
                    if (nx == sx && ny == sy) {
                        int px = x - dir[i][0];
                        int py = y - dir[i][1];
                        if (px >= 0 && px < m && py >= 0 && py < n && grid[px][py] != '#') {
                            if (dist[px][py][nd] == -1) {
                                dist[px][py][nd] = d;
                                q.push({px, py, nd});
                            }
                        }
                    } else {
                        if (dist[nx][ny][d] == -1) {
                            dist[nx][ny][d] = d;
    }
};