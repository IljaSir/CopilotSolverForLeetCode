class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    max = Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j]=0;
        int left = dfs(grid,i,j-1);
        int right = dfs(grid,i,j+1);
        int top = dfs(grid,i-1,j);
        int bottom = dfs(grid,i+1,j);
        grid[i][j]=temp;
        return grid[i][j]+Math.max(left,Math.max(right,Math.max(top,bottom)));
    }
}