class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int count = 0;
        boolean[][] grid = new boolean[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = true;
        }
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y]) {
                    break;
                }
                grid[i][y] = true;
            }
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y]) {
                    break;
                }
                grid[i][y] = true;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (grid[x][i]) {
                    break;
                }
                grid[x][i] = true;
            }
            for (int i = y + 1; i < n; i++) {
                if (grid[x][i]) {
                    break;
                }
                grid[x][i] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}