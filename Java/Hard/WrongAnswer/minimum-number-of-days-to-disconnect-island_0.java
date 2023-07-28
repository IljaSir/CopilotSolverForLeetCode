class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        if(count == 0 || count > 1){
            return 0;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(!check(grid)){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    private boolean check(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        if(count == 0 || count > 1){
            return false;
        }
        return true;
    }
}