class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int answer = 0;
        while (grid.length > 0) {
            int maxValue = 0;
            int maxRow = 0;
            int maxCol = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] > maxValue) {
                        maxValue = grid[row][col];
                        maxRow = row;
                        maxCol = col;
                    }
                }
            }
            answer += maxValue;
            grid = removeColumn(grid, maxCol);
        }
        return answer;
    }
    
    private int[][] removeColumn(int[][] grid, int col) {
        int[][] newGrid = new int[grid.length][grid[0].length - 1];
        for (int row = 0; row < grid.length; row++) {
            int newCol = 0;
            for (int oldCol = 0; oldCol < grid[row].length; oldCol++) {
                if (oldCol == col) {
                    continue;
                }
                newGrid[row][newCol] = grid[row][oldCol];
                newCol++;
            }
        }
        return newGrid;
    }
}