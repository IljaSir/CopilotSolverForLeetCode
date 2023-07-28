class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        vector<vector<vector<int>>> dp(maxMove + 1, vector<vector<int>>(m, vector<int>(n, 0)));
        dp[0][startRow][startColumn] = 1;
        long long res = 0;
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == 0) {
                        res += dp[i - 1][j][k];
                    }
                    if (j == m - 1) {
                        res += dp[i - 1][j][k];
                    }
                    if (k == 0) {
                        res += dp[i - 1][j][k];
                    }
                    if (k == n - 1) {
                        res += dp[i - 1][j][k];
                    }
                    res %= 1000000007;
                    dp[i][j][k] = ((j > 0 ? dp[i - 1][j - 1][k] : 0) + (j < m - 1 ? dp[i - 1][j + 1][k] : 0) + (k > 0 ? dp[i - 1][j][k - 1] : 0) + (k < n - 1 ? dp[i - 1][j][k + 1] : 0)) % 1000000007;
                }
            }
        }
        return res;
    }
};