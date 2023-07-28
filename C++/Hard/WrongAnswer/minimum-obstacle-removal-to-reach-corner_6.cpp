class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int dp[m][n];
        memset(dp, 0, sizeof(dp));
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = INT_MAX;
                }
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                }
                if(i > 0) {
                    dp[i][j] = min(dp[i][j], dp[i-1][j]);
                }
                if(j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i][j-1]);
                }
                if(dp[i][j] != INT_MAX) {
                    dp[i][j]++;
                }
            }
        }
        return dp[m-1][n-1];
    }
};