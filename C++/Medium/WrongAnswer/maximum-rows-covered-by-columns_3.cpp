class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> rowCover(m, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowCover[i] |= (1 << j);
                }
            }
        }
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                dp[j | rowCover[i]] = max(dp[j | rowCover[i]], dp[j] + 1);
            }
        }
        return dp[(1 << n) - 1];
    }
    int maximumRows2(vector<vector<int>>& matrix, int numSelect) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> rowCover(m, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowCover[i] |= (1 << j);
                }
            }
        }
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                dp[j | rowCover[i]] = max(dp[j | rowCover[i]], dp[j] + 1);
            }
        }
        return dp[(1 << n) - 1];
    }
};