class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] guard : guards) {
            for (int[] dir : dirs) {
                int x = guard[0] + dir[0];
                int y = guard[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1) {
                    grid[x][y] = 1;
                    x += dir[0];
                    y += dir[1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}