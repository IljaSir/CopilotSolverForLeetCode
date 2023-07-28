class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1e9 + 7;
        vector<vector<vector<long>>> dp(maxMove + 1, vector<vector<long>>(m, vector<long>(n, 0)));
        dp[0][startRow][startColumn] = 1;
        int res = 0;
        for (int move = 0; move < maxMove; move++) {
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (dp[move][row][col] == 0) continue;
                    if (row == 0) {
                        res = (res + dp[move][row][col]) % MOD;
                    } else {
                        dp[move + 1][row - 1][col] = (dp[move + 1][row - 1][col] + dp[move][row][col]) % MOD;
                    }
                    if (row == m - 1) {
                        res = (res + dp[move][row][col]) % MOD;
                    } else {
                        dp[move + 1][row + 1][col] = (dp[move + 1][row + 1][col] + dp[move][row][col]) % MOD;
                    }
                    if (col == 0) {
                        res = (res + dp[move][row][col]) % MOD;
                    } else {
                        dp[move + 1][row][col - 1] = (dp[move + 1][row][col - 1] + dp[move][row][col]) % MOD;
                    }
                    if (col == n - 1) {
                        res = (res + dp[move][row][col]) % MOD;
                    } else {
                        dp[move + 1][row][col + 1] = (dp[move + 1][row][col + 1] + dp[move][row][col]) % MOD;
                    }
                }
            }
        }
        return res;
    }
};