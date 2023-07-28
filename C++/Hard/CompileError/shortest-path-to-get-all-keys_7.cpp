class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sx, sy;
        int total = 0;
        vector<vector<int>> dist(m, vector<int>(n, 0));
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(64, INT_MAX)));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == '@') {
                    sx = i;
                    sy = j;
                } else if (c >= 'a' && c <= 'f') {
                    total |= (1 << (c - 'a'));
                }
            }
        }
        q.push({sx, sy});
        dp[sx][sy][0] = 0;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                char c = grid[nx][ny];
                if (c == '#') {
                    continue;
                }
                int keys = 0;
                if (c >= 'A' && c <= 'F') {
                    keys = (1 << (c - 'A'));
                }
                if (c >= 'a' && c <= 'f') {
                    keys = (1 << (c - 'a'));
                }
                if ((dp[x][y][keys] + 1) < dp[nx][ny][keys | dp[x][y][0]]) {
                    dp[nx][ny][keys | dp[x][y][0]] = dp[x][y][keys] + 1;
                    q.push({nx, ny});
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < 64; i++) {
            if ((i | total) == total) {
                ans = min(ans, dp[sx][sy][i]);
            }
        }
        return ans == INT_MAX ? -
    }
};