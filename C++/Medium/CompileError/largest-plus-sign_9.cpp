class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        int i, j, k, l, m, n, r, c, t, ans = 0;
        vector<vector<int>> grid(n, vector<int>(n, 1;
        for (auto& mine: mines {
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
                    dp[i][j] = min(dp[i][j], ++k);
                } else {
                    k = 0;
                }
            }
        }
        for (j = 0; j < n; j++) {
            for (i = 0, k = 0; i < n; i++) {
                if (grid[i][j] == 1) {
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
            for (int j = n - 1, cnt = 0; j >= 0; --j) {
                cnt = grid[i][j] == 0 ? 0 : cnt + 1;
                dp[i][j] = min(dp[i][j], cnt);
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0, cnt = 0; i < n; ++i) {
                cnt = grid[i][j] == 0 ? 0 : cnt + 1;
                dp[i][j] = min(dp[i][j], cnt);
            }
            for (int i = n - 1, cnt = 0; i >= 0; --i) {
                cnt = grid[i][j] == 0 ? 0 : cnt + 1;
                dp[i][j] = min(dp[i][j], cnt);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
};