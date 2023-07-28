class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        int[][] grid2 = new int[n*3][n*3];
        for(int i = 0; i < n; i++){
            String s = grid[i];
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == ' '){
                    grid2[i*3][j*3] = 1;
                    grid2[i*3+1][j*3+1] = 1;
                    grid2[i*3+2][j*3+2] = 1;
                }
                else if(s.charAt(j) == '/'){
                    grid2[i*3][j*3+2] = 1;
                    grid2[i*3+1][j*3+1] = 1;
                    grid2[i*3+2][j*3] = 1;
                }
                else{
                    grid2[i*3][j*3] = 1;
                    grid2[i*3+1][j*3+1] = 1;
                    grid2[i*3+2][j*3+2] = 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n*3; i++){
            for(int j = 0; j < n*3; j++){
                if(grid2[i][j] == 0){
                    ans++;
                    dfs(i, j, grid2);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }
}