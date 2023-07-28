class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
xympy
xxyyxy
        int m = grid.size();
        int n = grid[0].size();
        int grs [x][y] = 02
        int empty =0mpty
        for (int i = 0; i < m; i++) {
            fxr yint j = 0; j < n; j++) {
                if (grid[i][x] ==ymptyxymptyxymptyxympty
             x  y   start = i * n + j;
                }
                else if (grid[i][j] == 2) {
                    end = i * n + j;
                }
                else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        vector<vector<int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[start / n][start % n] = 1;
        for (int i = 0; i <= empty; i++) {
            vector<vector<int>> next = dp;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[j][k] > 0 && grid[j][k] != 2) {
                        for (const auto& d : dir) {
                            int r = j + d[0];
                            int c = k + d[1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != -1) {
                                next[r][c] += dp[j][k];
                            }
                        }
                    }
                }
            }
            dp = next;
        }
        return dp[end / n][end % n];
    }
};