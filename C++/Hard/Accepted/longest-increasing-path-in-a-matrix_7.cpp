class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int max_len = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max_len = max(max_len, dfs(matrix, dp, i, j));
            }
        }
        return max_len;
    }
    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int m = matrix.size();
        int n = matrix[0].size();
        int max_len = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            max_len = max(max_len, dfs(matrix, dp, i - 1, j));
        }
        if (i < m - 1 && matrix[i][j] < matrix[i + 1][j]) {
            max_len = max(max_len, dfs(matrix, dp, i + 1, j));
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            max_len = max(max_len, dfs(matrix, dp, i, j - 1));
        }
        if (j < n - 1 && matrix[i][j] < matrix[i][j + 1]) {
            max_len = max(max_len, dfs(matrix, dp, i, j + 1));
        }
        dp[i][j] = max_len + 1;
        return dp[i][j];
    }
};