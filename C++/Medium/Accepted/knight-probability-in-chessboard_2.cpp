class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        
        vector<vector<vector<double>>> dp(n, vector<vector<double>>(n, vector<double>(k + 1, -1.0)));
        return dfs(n, k, row, column, dp);
    }
    double dfs(int n, int k, int row, int column, vector<vector<vector<double>>> &dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0.0;
        if (k == 0) return 1.0;
        if (dp[row][column][k] >= 0.0) return dp[row][column][k];
        double res = 0.0;
        vector<vector<int>> dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        for (auto dir : dirs) {
            int x = row + dir[0], y = column + dir[1];
            res += 0.125 * dfs(n, k - 1, x, y, dp);
        }
        dp[row][column][k] = res;
        return res;
    }
};