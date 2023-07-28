class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        vector<vector<vector<int>>> dp(maxMove+1, vector<vector<int>>(m, vector<int>(n, -1)));
        int M = 1000000007;
        return dfs(m, n, maxMove, startRow, startColumn, dp) % M;
    }
    int dfs(int m, int n, int maxMove, int startRow, int startColumn, vector<vector<vector<int>>>& dp) {
        if (maxMove < 0) {
            return 0;
        }
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1;
        }
        if (dp[maxMove][startRow][startColumn] != -1) {
            return dp[maxMove][startRow][startColumn];
        }
        int M = 1000000007;
        dp[maxMove][startRow][startColumn] = 0;
        dp[maxMove][startRow][startColumn] += dfs(m, n, maxMove-1, startRow+1, startColumn, dp) % M;
        dp[maxMove][startRow][startColumn] += dfs(m, n, maxMove-1, startRow-1, startColumn, dp) % M;
        dp[maxMove][startRow][startColumn] += dfs(m, n, maxMove-1, startRow, startColumn+1, dp) % M;
        dp[maxMove][startRow][startColumn] += dfs(m, n, maxMove-1, startRow, startColumn-1, dp) % M;
        return dp[maxMove][startRow][startColumn];
    }
};