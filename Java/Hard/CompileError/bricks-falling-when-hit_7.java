class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int[] result = new int[hits.length];
        int[][] gridCopy = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }
        for(int i = 0; i < hits.length; i++) {
            gridCopy[hits[i][0]][hits[i][1]] = 0;
        }
        for(int i = 0; i < gridCopy[0].length; i++) {
            if(gridCopy[0][i] == 1) {
                dfs(gridCopy, 0, i);
            }
        }
        for(int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0) {
                continue;
            }
            gridCopy[x][y] = 1;
            if(x == 0 || gridCopy[x - 1][y] == 2 || gridCopy[x + 1][y] == 2 || gridCopy[x][y - 1] == 2 || gridCopy[x][y + 1] == 2) {
                dfs(gridCopy, x, y);
            }
            result[i] = getNumberOfBricks(gridCopy) - getNumberOfBricks(grid);
        }
        return result;
    }
    
    public void dfs(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        grid[x][y] = 2;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}