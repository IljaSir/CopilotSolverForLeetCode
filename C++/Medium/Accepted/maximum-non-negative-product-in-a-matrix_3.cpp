class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        long long dp[m][n][2];
        memset(dp, 0, sizeof(dp));
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i-1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i-1][0][1] * grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i-1][0] * grid[0][i];
            dp[0][i][1] = dp[0][i-1][1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long long tmp1 = dp[i-1][j][0] * grid[i][j];
                long long tmp2 = dp[i-1][j][1] * grid[i][j];
                long long tmp3 = dp[i][j-1][0] * grid[i][j];
                long long tmp4 = dp[i][j-1][1] * grid[i][j];
                dp[i][j][0] = min(min(tmp1, tmp2), min(tmp3, tmp4));
                dp[i][j][1] = max(max(tmp1, tmp2), max(tmp3, tmp4));
            }
        }
        if (dp[m-1][n-1][1] < 0) return -1;
        return dp[m-1][n-1][1] % 1000000007;
    }
};