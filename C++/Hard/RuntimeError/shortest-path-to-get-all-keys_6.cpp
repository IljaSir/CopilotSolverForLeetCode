class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int keys = 0;
        int start_x = 0, start_y = 0;
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(64, 0)));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isalpha(grid[i][j])) {
                    keys |= (1 << (grid[i][j] - 'a'));
                }
                if (grid[i][j] == '@') {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        int dirs[] = {0, 1, 0, -1, 0};
        queue<vector<int>> q;
        q.push({start_x, start_y, 0, 0});
        visited[start_x][start_y][0] = 1;
        while (!q.empty()) {
            auto node = q.front();
            q.pop();
            int x = node[0], y = node[1], k = node[2], step = node[3];
            if (k == keys) {
                return step;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '#') {
                    continue;
                }
                int nk = k;
                if (islower(grid[nx][ny])) {
                    nk |= (1 << (grid[nx][ny] - 'a'));
                }
                if (isupper(grid[nx][ny]) && !(nk & (1 << (grid[nx][ny] - 'A')))) {
                    continue;
                }
                if (!visited[nx][ny][nk]) {
                    visited[nx][ny][nk] = 1;
                    q.push({nx, ny, nk, step + 1});
                }
            }
        }
        return -1;
    }
};