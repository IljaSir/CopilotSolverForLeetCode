class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int N = grid.size(), M = grid[0].size();
        int sx, sy, totalKeys = 0;
        vector<vector<int>> keys(N, vector<int>(M));
        vector<vector<int>> locks(N, vector<int>(M));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '@') {
                    sx = i, sy = j;
                } else if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    keys[i][j] = 1 << (grid[i][j] - 'a');
                    totalKeys |= keys[i][j];
                } else if (grid[i][j] >= 'A' && grid[i][j] <= 'F') {
                    locks[i][j] = 1 << (grid[i][j] - 'A');
                }
            }
        }
        queue<tuple<int, int, int>> q;
        q.emplace(sx, sy, 0);
        vector<vector<int>> visited(N, vector<int>(M, 0));
        visited[sx][sy] = 1;
        int res = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                auto [x, y, k] = q.front();
                q.pop();
                if (k == totalKeys) {
                    return res;
                }
                for (int dx : {1, 0, -1, 0}) {
                    for (int dy : {0, 1, 0, -1}) {
                        int nx = x + dx, ny = y + dy;
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || grid[nx][ny] == '#') {
                            continue;
                        }
                        int nk = k;
                        if (keys[nx][ny]) {
                            nk |= keys[nx][ny];
                        }
                        if (locks[nx][ny] && !(k & locks[nx][ny])) {
                            continue;
                        }
                        if (visited[nx][ny] & (1 << nk)) {
                            continue;
                        }
                        visited[nx][ny] |=
    }
};