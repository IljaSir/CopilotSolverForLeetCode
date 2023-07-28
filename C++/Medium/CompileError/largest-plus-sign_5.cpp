class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        vector<vector<int>> grid(n, vector<int>(n, 1));
        for (ato &mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0, cnt = 0; j < n; ++j) {
                cnt = grid[i][j] == 0 ? 0 : cnt + 1;
                dp[i][j] = cnt;
            }
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