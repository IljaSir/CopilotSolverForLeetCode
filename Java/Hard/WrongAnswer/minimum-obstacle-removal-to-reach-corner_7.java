class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }
                if(i > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                }
                if(i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
                if(grid[i][j] == 1 && dp[i][j] < Integer.MAX_VALUE){
                    dp[i][j]++;
                }
            }
        }
        return dp[m-1][n-1];
    }
}