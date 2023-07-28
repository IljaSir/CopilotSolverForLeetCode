class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        int i, j, k, l, m, n, r, c, t, ans = 0;
        vector<vector<int>> grid(n, vector<int>(n, 1));
        for (auto& mine: mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (i = 0; i < n; i++) {
            for (j = 0, k = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = ++k;
                } else {
                    k = 0;
                }
            }
            for (j = n - 1, k = 0; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = mi(dp, ++k);
                } else {
                    k = 0;
                }
            }
        }
        for (j = 0; j < n; j++ {
            for (i = 0, k = 0; i < n; i++ {
                if (grid[i][j] == 1 {
                    dp[i][j] = min(dp[i][j], ++k);
                } else {
                    k = 0;
                }
            }
            for (i = n - 1, k = 0; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = min(dp[i][j], ++k);
                    ans = max(ans, dp[i][j]);
                } else {
                    k = 0
                }
            }
        }
        return ans;
    }
};