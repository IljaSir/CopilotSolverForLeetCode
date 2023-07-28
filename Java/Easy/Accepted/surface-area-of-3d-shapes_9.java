class Solution {
    public int surfaceArea(int[][] grid) {
        
        int n = grid.length;
        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int v = grid[i][j];
                if(v==0) continue;
                total+=4*v+2;
                if(j-1>=0) total-=2*Math.min(grid[i][j-1],v);
                if(i-1>=0) total-=2*Math.min(grid[i-1][j],v);
            }
        }
        return total;
    }
}