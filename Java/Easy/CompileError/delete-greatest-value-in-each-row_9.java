class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int result = 0;
        while(grid.length > 0) {
            int maxInRow = Integer.MIN_VALUE;
            int maxInRowIdx = -1;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] > maxInRow) {
                        maxInRow = grid[i][j];
                        maxInRowIdx = i;
                    }
                }
            }
            result += maxInRow;
            int[][] newGrid = new int[grid.length - 1][grid[0].length - 1];
            for(int i = 0, k = 0; i < grid.length; i++) {
                if(i == maxInRowIdx) continue;
                for(int j = 0, l = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == maxInRow) continue;
                    newGrid[k][l++] = grid[i][j];
                }
                k++;
            }
            grid = newGrid;
        }
        return result;
    }
}
    }
}