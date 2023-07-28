class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        vector<vector<vector<long>>> dp(maxMove + 1, vector<vector<long>>(m, vector<long>(n, 0)));
        int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < 4; l++) {
                        int x = j + dir[l][0];
                        int y = k + dir[l][1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            dp[i][j][k]++;
                        } else {
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][x][y]) % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[maxMove][startRow][startColumn];
    }
};