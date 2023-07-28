class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        const int MOD = 1e9 + 7;
        vector<vector<vector<int>>> dp(maxMove + 1, vector<vector<int>>(m, vector<int>(n, 0)));
        int res = 0;
        for (int k = 1; k <= maxMove; ++k) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[k][i][j] = ((i == 0 ? 1 : dp[k - 1][i - 1][j]) + (i == m - 1 ? 1 : dp[k - 1][i + 1][j]) + (j == 0 ? 1 : dp[k - 1][i][j - 1]) + (j == n - 1 ? 1 : dp[k - 1][i][j + 1])) % MOD;
                    if (k == maxMove && (i == startRow && j == startColumn)) {
                        res = (res + dp[k][i][j]) % MOD;
                    }
                }
            }
        }
        return res;
    }
};