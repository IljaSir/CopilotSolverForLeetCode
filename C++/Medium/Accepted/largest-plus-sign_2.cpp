class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        vector<vector<int>> dp(n, vector<int>(n, n));
        for (auto &m : mines) dp[m[0]][m[1]] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0, l = 0, r = 0, u = 0, d = 0; j < n; ++j) {
                dp[i][j] = min(dp[i][j], l = (dp[i][j] == 0 ? 0 : l + 1));
                dp[i][n - 1 - j] = min(dp[i][n - 1 - j], r = (dp[i][n - 1 - j] == 0 ? 0 : r + 1));
                dp[j][i] = min(dp[j][i], u = (dp[j][i] == 0 ? 0 : u + 1));
                dp[n - 1 - j][i] = min(dp[n - 1 - j][i], d = (dp[n - 1 - j][i] == 0 ? 0 : d + 1));
            }
        }
        int res = 0;
        for (auto &row : dp) for (auto &val : row) res = max(res, val);
        return res;
    }
};