class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            grid[row][col] = 1;
            for (int i = row - 1; i >= 0; i--) {
                if (grid[i][col] == 2) {
                    break;
                }
                grid[i][col] = 1;
            }
            for (int i = row + 1; i < m; i++) {
                if (grid[i][col] == 2) {
                    break;
                }
                grid[i][col] = 1;
            }
            for (int j = col - 1; j >= 0; j--) {
                if (grid[row][j] == 2) {
                    break;
                }
                grid[row][j] = 1;
            }
            for (int j = col + 1; j < n; j++) {
                if (grid[row][j] == 2) {
                    break;
                }
                grid[row][j] = 1;
            }
        }
        for (int[] wall : walls) {
            int row = wall[0];
            int col = wall[1];
            grid[row][col] = 2;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}