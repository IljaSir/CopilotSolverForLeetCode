class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int ans = 0;
        while (grid.length > 0) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                for (int j = 0; j < row.length; j++) {
                    max = Math.max(max, row[j]);
                }
            }
            ans += max;
            int[][] newGrid = new int[grid.length][];
            int newGridIndex = 0;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                int[] newRow = new int[row.length - 1];
                int newRowIndex = 0;
                boolean deleted = false;
                for (int j = 0; j < row.length; j++) {
                    if (!deleted && row[j] == max) {
                        deleted = true;
                        continue;
                    }
                    newRow[newRowIndex++] = row[j];
                }
                if (newRow.length > 0) {
                    newGrid[newGridIndex++] = newRow;
                }
            }
            grid = new int[newGridIndex][];
            for (int i = 0; i < newGridIndex; i++) {
                grid[i] = newGrid[i];
            }
        }
        return ans;
    }
}