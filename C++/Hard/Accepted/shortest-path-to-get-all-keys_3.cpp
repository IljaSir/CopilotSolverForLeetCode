class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int sx, sy, all = 0;
        vector<vector<vector<int>>> dist(m, vector<vector<int>>(n, vector<int>(1 << 6, -1)));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '@') {
                    sx = i; sy = j;
                } else if (islower(grid[i][j])) {
                    all |= 1 << (grid[i][j] - 'a');
                }
            }
        }
        queue<pair<int, int>> q;
        q.push({sx * n + sy, 0});
        dist[sx][sy][0] = 0;
        while (!q.empty()) {
            int x = q.front().first / n, y = q.front().first % n, s = q.front().second;
            q.pop();
            if (s == all) {
                return dist[x][y][s];
            }
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (abs(i) + abs(j) != 1) {
                        continue;
                    }
                    int nx = x + i, ny = y + j, ns = s;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                        continue;
                    }
                    if (islower(grid[nx][ny])) {
                        ns |= 1 << (grid[nx][ny] - 'a');
                    }
                    if (isupper(grid[nx][ny]) && !(ns >> (grid[nx][ny] - 'A') & 1)) {
                        continue;
                    }
                    if (dist[nx][ny][ns] == -1) {
                        dist[nx][ny][ns] = dist[x][y][s] + 1;
                        q.push({nx * n + ny, ns});
                    }
                }
            }
        }
        return -1;
    }
};