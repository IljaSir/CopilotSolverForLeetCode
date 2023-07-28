class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        if (n == 0) return 0;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> visited(m, vector<int>(n, 0));
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = max(ans, dfs(matrix, i, j, visited, dp));
            }
        }
        return ans;
    }
    int dfs(vector<vector<int>>& matrix, int x, int y, vector<vector<int>>& visited, vector<vector<int>>& dp) {
        if (visited[x][y]) return dp[x][y];
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = 1;
        if (x > 0 && matrix[x][y] < matrix[x - 1][y]) {
            ans = max(ans, 1 + dfs(matrix, x - 1, y, visited, dp));
        }
        if (x < m - 1 && matrix[x][y] < matrix[x + 1][y]) {
            ans = max(ans, 1 + dfs(matrix, x + 1, y, visited, dp));
        }
        if (y > 0 && matrix[x][y] < matrix[x][y - 1]) {
            ans = max(ans, 1 + dfs(matrix, x, y - 1, visited, dp));
        }
        if (y < n - 1 && matrix[x][y] < matrix[x][y + 1]) {
            ans = max(ans, 1 + dfs(matrix, x, y + 1, visited, dp));
        }
        visited[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }
};