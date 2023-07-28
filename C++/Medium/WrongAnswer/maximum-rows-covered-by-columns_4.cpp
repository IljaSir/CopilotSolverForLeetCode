class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> dp(n, vector<int>(1 << m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) continue;
                for (int s = 0; s < (1 << m); s++) {
                    if (s & (1 << j)) {
                        dp[i][s] += 1;
                    }
                }
            }
        }
        vector<vector<int>> dp2(n + 1, vector<int>(1 << m, 0));
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < (1 << m); s++) {
                dp2[i + 1][s] = max(dp2[i + 1][s], dp2[i][s]);
                dp2[i + 1][s] = max(dp2[i + 1][s], dp2[i][s ^ ((1 << m) - 1)] + dp[i][s]);
            }
        }
        return dp2[n][(1 << m) - 1];
    }
};