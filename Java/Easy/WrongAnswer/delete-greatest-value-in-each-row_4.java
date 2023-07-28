class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int result = 0;
        while (grid.length > 0) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                for (int j = 0; j < row.length; j++) {
                    if (row[j] > max) {
                        max = row[j];
                        maxIndex = i;
                    }
                }
            }
            result += max;
            int[] newRow = new int[grid[0].length - 1];
            int index = 0;
            for (int i = 0; i < grid[maxIndex].length; i++) {
                if (i != maxIndex) {
                    newRow[index++] = grid[maxIndex][i];
                }
            }
            int[][] newGrid = new int[grid.length - 1][];
            index = 0;
            for (int i = 0; i < grid.length; i++) {
                if (i != maxIndex) {
                    newGrid[index++] = grid[i];
                }
            }
            grid = newGrid;
        }
        return result;
    }
}