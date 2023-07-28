class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        vector<vector<vector<long>>> dp(m, vector<vector<long>>(n, vector<long>(maxMove + 1)));
        return dfs(m, n, maxMove, startRow, startColumn, dp);
    }
    int dfs(int m, int n, int maxMove, int startRow, int startColumn, vector<vector<vector<long>>>& dp) {
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) return 1;
        if (maxMove == 0) return 0;
        if (dp[startRow][startColumn][maxMove] != 0) return dp[startRow][startColumn][maxMove];
        int res = 0;
        res = (res + dfs(m, n, maxMove - 1, startRow - 1, startColumn, dp)) % 1000000007;
        res = (res + dfs(m, n, maxMove - 1, startRow + 1, startColumn, dp)) % 1000000007;
        res = (res + dfs(m, n, maxMove - 1, startRow, startColumn - 1, dp)) % 1000000007;
        res = (res + dfs(m, n, maxMove - 1, startRow, startColumn + 1, dp)) % 1000000007;
        dp[startRow][startColumn][maxMove] = res;
        return res;
    }
};