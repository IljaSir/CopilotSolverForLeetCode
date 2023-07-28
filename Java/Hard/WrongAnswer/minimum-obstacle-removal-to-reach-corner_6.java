class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    continue;
                }
                int k = 0;
                while(i+k<m && grid[i+k][j] == 0){
                    dp[i+k][j] = Math.min(dp[i+k][j],dp[i][j]);
                    k++;
                }
                k = 0;
                while(j+k<n && grid[i][j+k] == 0){
                    dp[i][j+k] = Math.min(dp[i][j+k],dp[i][j]);
                    k++;
                }
                if(i>0 && j>0 && grid[i-1][j] == 0 && grid[i][j-1] == 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m-1][n-1];
    }
}