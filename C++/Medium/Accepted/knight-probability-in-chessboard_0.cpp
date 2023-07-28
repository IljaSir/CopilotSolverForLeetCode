class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<vector<double>>> dp(n, vector<vector<double>>(n, vector<double>(k + 1, -1)));
        return dfs(n, k, row, column, dp);
    }
    
    double dfs(int n, int k, int row, int column, vector<vector<vector<double>>>& dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != -1) {
            return dp[row][column][k];
        }
        double res = 0;
        res += 0.125 * dfs(n, k - 1, row + 2, column + 1, dp);
        res += 0.125 * dfs(n, k - 1, row + 2, column - 1, dp);
        res += 0.125 * dfs(n, k - 1, row - 2, column + 1, dp);
        res += 0.125 * dfs(n, k - 1, row - 2, column - 1, dp);
        res += 0.125 * dfs(n, k - 1, row + 1, column + 2, dp);
        res += 0.125 * dfs(n, k - 1, row + 1, column - 2, dp);
        res += 0.125 * dfs(n, k - 1, row - 1, column + 2, dp);
        res += 0.125 * dfs(n, k - 1, row - 1, column - 2, dp);
        dp[row][column][k] = res;
        return res;
    }
};