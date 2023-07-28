class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> visited(m, vector<int>(n, 0));
        vector<int> dx = {0, 0, 1, -1};
        vector<int> dy = {1, -1, 0, 0};
        int res = 0;
        function<int(int, int)> dfs = [&](int x, int y) {
            if (visited[x][y]) return dp[x][y];
            dp[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > grid[x][y]) {
                    dp[x][y] = (dp[x][y] + dfs(nx, ny)) % mod;
                }
            }
            visited[x][y] = 1;
            return dp[x][y];
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dfs(i, j)) % mod;
            }
        }
        return res;
    }
};