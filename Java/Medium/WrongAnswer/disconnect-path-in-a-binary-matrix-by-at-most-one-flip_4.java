class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return false;
        if(grid[0][0] == 0 || grid[m-1][n-1] == 0) return false;
        if(m == 1){
            for(int i=1; i<n; i++){
                if(grid[0][i] == 0) return true;
            }
            return false;
        }
        if(n == 1){
            for(int i=1; i<m; i++){
                if(grid[i][0] == 0) return true;
            }
            return false;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1; i<m; i++){
            if(grid[i][0] == 0) dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }
        for(int i=1; i<n; i++){
            if(grid[0][i] == 0) dp[0][i] = 1;
            else dp[0][i] = dp[0][i-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j] == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        if(dp[m-1][n-1] == 1) return true;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j] == 0){
                    int paths = dp[i-1][j] + dp[i][j-1];
                    if(paths > 1) return true;
                }
            }
        }
        return false;
    }
}