class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> rows(m);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] = rows[i] * 2 + matrix[i][j];
            }
        }
        vector<int> dp(1 << n);
        for (int i = 0; i < m; ++i) {
            for (int j = (1 << n) - 1; j >= 0; --j) {
                dp[j | rows[i]] = max(dp[j | rows[i]], dp[j] + 1);
            }
        }
        return dp[(1 << n) - 1];
    }
};