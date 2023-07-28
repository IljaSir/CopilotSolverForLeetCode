class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = max(res, dfs(matrix, i, j, m, n, dp));
            }
        }
        return res;
    }
    int dfs(vector<vector<int>>& matrix, int i, int j, int m, int n, vector<vector<int>>& dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = 0;
        if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            res = max(res, dfs(matrix, i - 1, j, m, n, dp));
        }
        if(i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
            res = max(res, dfs(matrix, i + 1, j, m, n, dp));
        }
        if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            res = max(res, dfs(matrix, i, j - 1, m, n, dp));
        }
        if(j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
            res = max(res, dfs(matrix, i, j + 1, m, n, dp));
        }
        dp[i][j] = res + 1;
        return dp[i][j];
    }
};