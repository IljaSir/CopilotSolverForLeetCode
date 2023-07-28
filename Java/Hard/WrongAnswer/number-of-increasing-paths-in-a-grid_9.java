class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int[] dir:dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y] > grid[i][j]){
                        dp[i][j] += dp[x][y];
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans += dp[i][j];
            }
        }
        return ans;
    }
}