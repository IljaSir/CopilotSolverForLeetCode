class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size();
        int n = grid[0].size();
        int k = queries.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = max(dp[i][j + 1], max(dp[i + 1][j], dp[i][j])) + (grid[i][j] <= queries[0]);
            }
        }
        vector<int> ans;
        for (int i = 0; i < k; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (grid[j][l] <= queries[i]) {
                        cur = max(cur, dp[j + 1][l + 1]);
                    }
                }
            }
            ans.push_back(cur);
        }
        return ans;
    }
};