class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int M = grid.size();
        int N = grid[0].size();
        vector<vector<int>> dp(M, vector<int>(N, 0));
        vector<vector<int>> visited(M, vector<int>(N, 0));
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count += dfs(grid, dp, visited, i, j);
                count %= 1000000007;
            }
        }
        return count;
    }
    int dfs(vector<vector<int>>& grid, vector<vector<int>>& dp, vector<vector<int>>& visited, int i, int j) {
        if (visited[i][j] == 1) return dp[i][j];
        int count = 0;
        int M = grid.size();
        int N = grid[0].size();
        if (i > 0 && grid[i-1][j] < grid[i][j]) count += dfs(grid, dp, visited, i-1, j);
        if (i < M-1 && grid[i+1][j] < grid[i][j]) count += dfs(grid, dp, visited, i+1, j);
        if (j > 0 && grid[i][j-1] < grid[i][j]) count += dfs(grid, dp, visited, i, j-1);
        if (j < N-1 && grid[i][j+1] < grid[i][j]) count += dfs(grid, dp, visited, i, j+1);
        if (count == 0) count = 1;
        dp[i][j] = count;
        visited[i][j] = 1;
        return count;
    }
};