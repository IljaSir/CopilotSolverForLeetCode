class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                dp[i][j] = trailingZeros(grid[i][j]);
                if(i < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }
                if(j < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
    private int trailingZeros(int x) {
        int res = 0;
        while(x % 5 == 0) {
            res++;
            x /= 5;
        }
        return res;
    }
}