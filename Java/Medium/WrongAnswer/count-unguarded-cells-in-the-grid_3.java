class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        for (int[] guard : guards) {
            for (int[] direction : directions) {
                int x = guard[0] + direction[0];
                int y = guard[1] + direction[1];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1) {
                    if (grid[x][y] == 0) {
                        grid[x][y] = 2;
                        count++;
                    }
                    x += direction[0];
                    y += direction[1];
                }
            }
        }
        return count;
    }
}