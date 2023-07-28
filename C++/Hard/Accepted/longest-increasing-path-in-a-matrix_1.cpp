class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        if (n == 0) return 0;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxLen = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxLen = max(maxLen, dfs(matrix, dp, i, j, m, n));
            }
        }
        return maxLen;
    }
    int dfs(vector<vector<int>> &matrix, vector<vector<int>> &dp, int i, int j, int m, int n) {
        if (dp[i][j] > 0) return dp[i][j];
        int maxLen = 0;
        if (i > 0 && matrix[i][j] < matrix[i-1][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i-1, j, m, n));
        }
        if (i < m-1 && matrix[i][j] < matrix[i+1][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i+1, j, m, n));
        }
        if (j > 0 && matrix[i][j] < matrix[i][j-1]) {
            maxLen = max(maxLen, dfs(matrix, dp, i, j-1, m, n));
        }
        if (j < n-1 && matrix[i][j] < matrix[i][j+1]) {
            maxLen = max(maxLen, dfs(matrix, dp, i, j+1, m, n));
        }
        dp[i][j] = maxLen + 1;
        return dp[i][j];
    }
};