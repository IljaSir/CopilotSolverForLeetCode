class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] guard : guards) {
            for (int[] direction : directions) {
                int row = guard[0], col = guard[1];
                while (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] != -1) {
                    grid[row][col] = 1;
                    row += direction[0];
                    col += direction[1];
                }
            }
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