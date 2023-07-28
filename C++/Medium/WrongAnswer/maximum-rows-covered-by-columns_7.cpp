class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int res = 0;
        vector<vector<int>> dp(m, vector<int>(1 << n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][1 << j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) == 0) {
                        dp[i][j | (1 << k)] = max(dp[i][j | (1 << k)], dp[i][j] + matrix[i][k]);
                    }
                }
            }
        }
        vector<vector<int>> dp2(m + 1, vector<int>((1 << n), 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp2[i][j] = dp2[i - 1][j];
                for (int k = 0; k < (1 << n); k++) {
                    if ((j & k) == 0) {
                        dp2[i][j] = max(dp2[i][j], dp2[i - 1][j | k] + dp[i - 1][k]);
                    }
                }
            }
        }
        return dp2[m][(1 << n) - 1];
    }
};