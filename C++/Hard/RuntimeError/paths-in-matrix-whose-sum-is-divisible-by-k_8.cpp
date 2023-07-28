class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k, -1)));
        return numberOfPaths(grid, k, 0, 0, dp);
    }
    int numberOfPaths(vector<vector<int>>& grid, int k, int i, int j, vector<vector<vector<int>>>& dp) {
        if (i >= grid.size() || j >= grid[0].size()) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        int sum = grid[i][j] + k;
        if (i == grid.size() - 1 && j == grid[0].size() - 1) {
            dp[i][j][k] = sum % grid[i][j] == 0 ? 1 : 0;
            return dp[i][j][k];
        }
        dp[i][j][k] = numberOfPaths(grid, sum % grid[i][j], i + 1, j, dp) + numberOfPaths(grid, sum % grid[i][j], i, j + 1, dp);
        return dp[i][j][k];
    }
};