class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> dp = grid[0];
        for (int i = 1; i < n; ++i) {
            vector<int> ndp(n, INT_MAX);
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k)
                    if (j != k) ndp[j] = min(ndp[j], dp[k]);
                ndp[j] += grid[i][j];
            }
            dp = ndp;
        }
        return *min_element(dp.begin(), dp.end());
    }
};