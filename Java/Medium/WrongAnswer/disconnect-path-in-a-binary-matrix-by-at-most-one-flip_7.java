class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i=1;i<n;i++){
            if(grid[i][0] == 1 && dp[i-1][0] == 1){
                dp[i][0] = 1;
            }
        }
        for(int i=1;i<m;i++){
            if(grid[0][i] == 1 && dp[0][i-1] == 1){
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j] == 1 && (dp[i-1][j] == 1 || dp[i][j-1] == 1)){
                    dp[i][j] = 1;
                }
            }
        }
        if(dp[n-1][m-1] == 1){
            return true;
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    if(!isPossibleToCutPath(grid)){
                        return true;
                    }
                    grid[i][j] = 0;
                }
            }
        }
        return false;
    }
}