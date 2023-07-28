class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int M = grid.size();
        int N = grid[0].size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(M, vector<int>(N, 0));
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                for (auto& dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= M || y < 0 || y >= N) continue;
                    if (grid[x][y] >= grid[i][j]) continue;
                    dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                }
                if (i == 0 && j == 0) dp[i][j] = 1;
            }
        }
        return dp[M - 1][N - 1];
    }
};