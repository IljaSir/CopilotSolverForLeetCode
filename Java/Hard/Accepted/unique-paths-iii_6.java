class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                }
                if(grid[i][j] == 2){
                    end[0] = i;
                    end[1] = j;
                }
                if(grid[i][j] == 0){
                    count++;
                }
            }
        }
        return dfs(grid, start[0], start[1], end[0], end[1], count);
    }
    public int dfs(int[][] grid, int x, int y, int endX, int endY, int count){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1){
            return 0;
        }
        if(x == endX && y == endY){
            return count == -1 ? 1 : 0;
        }
        grid[x][y] = -1;
        int res = dfs(grid, x + 1, y, endX, endY, count - 1) + dfs(grid, x - 1, y, endX, endY, count - 1) + dfs(grid, x, y + 1, endX, endY, count - 1) + dfs(grid, x, y - 1, endX, endY, count - 1);
        grid[x][y] = 0;
        return res;
    }
}