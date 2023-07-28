class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    count++;
                    if(count > 1) return 0;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        if(count == 0) return 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    count = 0;
                    for(int k=0; k<m; k++){
                        for(int l=0; l<n; l++){
                            if(grid[k][l] == 1){
                                count++;
                                if(count > 1) return 1;
                                dfs(grid, k, l, dirs);
                            }
                        }
                    }
                    return 2;
                }
            }
        }
        return 0;
    }
    private void dfs(int[][] grid, int i, int j, int[][] dirs){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = 0;
        for(int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) continue;
            dfs(grid, x, y, dirs);
        }
    }
}