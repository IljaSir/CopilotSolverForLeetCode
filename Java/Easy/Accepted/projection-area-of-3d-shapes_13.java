class Solution {
    public int projectionArea(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    ans++;
                }
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            ans+=row[i];
        }
        for(int i=0;i<m;i++){
            ans+=col[i];
        }
        return ans;
    }
}