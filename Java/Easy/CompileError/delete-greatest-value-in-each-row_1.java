class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int sum = 0;
        while (grid.length > 0) {
            int max = 0;
            int index = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        index = i;
                    }
                }
            }
            sum += max;
            int[][] newGrid = new int[grid.length - 1][grid[0].length - 1];
            int k = 0;
            for (int i = 0; i < grid.length; i++) {
                if (i != index) {
                    int l = 0;
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] != max) {
                            newGrid[k][l] = grid[i][j];
                            l++;
                        }
                    }
                    k++;
                }
            }
            grid = newGrid;
        }
        return sum;
    }
}
    }
}