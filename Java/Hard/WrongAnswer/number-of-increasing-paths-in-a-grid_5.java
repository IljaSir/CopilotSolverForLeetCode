class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = 1;
                if(i>0 && grid[i][j] > grid[i-1][j]){
                    dp[i][j] = (dp[i][j] + dp[i-1][j])%mod;
                }
                if(j>0 && grid[i][j] > grid[i][j-1]){
                    dp[i][j] = (dp[i][j] + dp[i][j-1])%mod;
                }
            }
        }
        return dp[m-1][n-1];
    }
}