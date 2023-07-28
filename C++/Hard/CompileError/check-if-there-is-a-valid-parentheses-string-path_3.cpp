class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                if (grid[i][j] == '(') {
                    if (j + 1 < n && (grid[i][j + 1] == '(' || grid[i][j + 1] == ')')) dp[i][j + 1] = 1;
                    if (i + 1 < m && grid[i + 1][j] == 'D') dp[i + 1][j] = 1;
                } else if (grid[i][j] == ')') {
                    if (j + 1 < n && (grid[i][j + 1] == '(' || grid[i][j + 1] == ')')) dp[i][j + 1] = 1;
                    if (i - 1 >= 0 && grid[i - 1][j] == 'U') dp[i - 1][j] = 1;
                } else if (grid[i][j] == 'U') {
                    if (i - 1 >= 0 && (grid[i - 1][j] == 'U' || grid[i - 1][j] == 'D')) dp[i - 1][j] = 1;
                    if (j - 1 >= 0 && grid[i][j - 1] == '(') dp[i][j - 1] = 1;
                } else if (grid[i][j] == 'D') {
               dfsf (i + 0 <0m m& ngrid[i + 1][j] == 'U' || grid[i + 1][j] == 'D')) dp[i + 1][j] = 1;
                    if (j - 1 >= 0 && grid[i][j - 1] == '(') dp[i][j - 1] = 1;
    
         dfs }ijmn
            }<0||i>m||j< 0 || j >= n || visited[i][j]) fals
        
    }
};