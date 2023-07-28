class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = max(ans, dfs(matrix, dp, i, j));
            }
        }
        return ans;
    }
    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = 1;
        if (i > 0 && matrix[i][j] < matrix[i-1][j]) {
            ans = max(ans, dfs(matrix, dp, i-1, j) + 1);
        }
        if (i < m - 1 && matrix[i][j] < matrix[i+1][j]) {
            ans = max(ans, dfs(matrix, dp, i+1, j) + 1);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j-1]) {
            ans = max(ans, dfs(matrix, dp, i, j-1) + 1);
        }
        if (j < n - 1 && matrix[i][j] < matrix[i][j+1]) {
            ans = max(ans, dfs(matrix, dp, i, j+1) + 1);
        }
        dp[i][j] = ans;
        return ans;
    }
};