class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = m - 1; i >= 0; i--) {
            vector<vector<int>> dp2(n, vector<int>(n, 0));
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int cur = 0;
                    cur += grid[i][j];
                    if (j != k) cur += grid[i][k];
                    int mx = 0;
                    for (int j2 = j - 1; j2 <= j + 1; j2++) {
                        for (int k2 = k - 1; k2 <= k + 1; k2++) {
                            if (j2 >= 0 && j2 < n && k2 >= 0 && k2 < n) {
                                mx = max(mx, dp[j2][k2]);
                            }
                        }
                    }
                    dp2[j][k] = cur + mx;
                }
            }
            dp = dp2;
        }
        return dp[0][n - 1];
    }
};