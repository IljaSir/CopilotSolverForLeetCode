class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(grid[i-1][j-1]>dp[i][j]){
                    dp[i][j] = grid[i-1][j-1];
                }
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int max = 0;
            for(int j=1;j<=m;j++){
                for(int k=1;k<=n;k++){
                    if(grid[j-1][k-1]<=queries[i]){
                        max = Math.max(max,dp[j][k]);
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}