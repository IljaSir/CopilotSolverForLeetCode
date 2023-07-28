class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    for(int j1 = j - 1; j1 <= j + 1; j1++){
                        for(int k1 = k - 1; k1 <= k + 1; k1++){
                            if(j1 >= 0 && j1 < n && k1 >= 0 && k1 < n){
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j1][k1]);
                            }
                        }
                    }
                    if(dp[i][j][k] >= 0){
                        dp[i][j][k] += grid[i][j] + grid[i][k];
                        if(j == k){
                            dp[i][j][k] -= grid[i][j];
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                res = Math.max(res, dp[m - 1][j][k]);
            }
        }
        return res;
    }
}