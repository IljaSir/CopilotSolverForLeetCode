class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        vector<vector<int>> dp(m, vector<int>(n));
        dp[startRow][startColumn] = 1;
        int result = 0;
        vector<vector<int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < maxMove; i++) {
            vector<vector<int>> dp2(m, vector<int>(n));
            for (int r = 0; r < m; ++r) {
                for (int c = 0; c < n; ++c) {
                    int count = dp[r][c];
                    if (count > 0) {
                        for (auto& d : directions) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                result = (result + count) % MOD;
                            } else {
                                dp2[nr][nc] = (dp2[nr][nc] + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return result;
    }
};