class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < m; ++i) {
            int mask = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    mask |= (1 << j);
                }
            }
            for (int j = mask; j; j = (j - 1) & mask) {
                dp[j] = max(dp[j], dp[j ^ mask] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            if (__builtin_popcount(i) == numSelect) {
                ans = max(ans, dp[i]);
            }
        }
        return ans;
    }
};