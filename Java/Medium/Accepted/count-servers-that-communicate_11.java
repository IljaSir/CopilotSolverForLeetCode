class Solution {
    public int countServers(int[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}