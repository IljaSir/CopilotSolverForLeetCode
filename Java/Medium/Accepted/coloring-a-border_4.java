class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                result[i][j] = grid[i][j];
            }
        }
        dfs(grid, row, col, color, grid[row][col], visited, result);
        return result;
    }
    
    public void dfs(int[][] grid, int row, int col, int color, int prevColor, int[][] visited, int[][] result){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] != prevColor){
            return;
        }
        visited[row][col] = 1;
        int count = 0;
        if(row - 1 >= 0 && grid[row - 1][col] == prevColor){
            count++;
            dfs(grid, row - 1, col, color, prevColor, visited, result);
        }
        if(row + 1 < grid.length && grid[row + 1][col] == prevColor){
            count++;
            dfs(grid, row + 1, col, color, prevColor, visited, result);
        }
        if(col - 1 >= 0 && grid[row][col - 1] == prevColor){
            count++;
            dfs(grid, row, col - 1, color, prevColor, visited, result);
        }
        if(col + 1 < grid[0].length && grid[row][col + 1] == prevColor){
            count++;
            dfs(grid, row, col + 1, color, prevColor, visited, result);
        }
        if(count < 4){
            result[row][col] = color;
        }
    }
}