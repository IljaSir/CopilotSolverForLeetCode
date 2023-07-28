class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<vector<double>>> dp(k+1, vector<vector<double>>(n, vector<double>(n, 0)));
        int dir[8][2] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        dp[0][row][column] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int l = 0; l < n; ++l) {
                    for (auto d : dir) {
                        int x = j + d[0];
                        int y = l + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[i][j][l] += dp[i-1][x][y];
                        }
                    }
                }
            }
        }
        double ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += dp[k][i][j];
            }
        }
        return ans / pow(8, k);
    }
};