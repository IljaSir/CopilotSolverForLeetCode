class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = max(maxLen, dfs(matrix, dp, i, j));
            }
        }
        return maxLen;
    }
    
    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int m = matrix.size();
        int n = matrix[0].size();
        int maxLen = 0;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i - 1, j));
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i + 1, j));
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i, j - 1));
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            maxLen = max(maxLen, dfs(matrix, dp, i, j + 1));
        }
        dp[i][j] = maxLen + 1;
        return dp[i][j];
    }
};