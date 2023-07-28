class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int sum = 0;
        while (true) {
            int max = 0;
            int maxRow = -1;
            int maxCol = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
            if (maxRow == -1) {
                break;
            }
            sum += max;
            grid[maxRow][maxCol] = 0;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                int[] newRow = new int[row.length - 1];
                int k = 0;
                for (int j = 0; j < row.length; j++) {
                    if (j != maxCol) {
                        newRow[k++] = row[j];
                    }
                }
                grid[i] = newRow;
            }
        }
        return sum;
    }
}