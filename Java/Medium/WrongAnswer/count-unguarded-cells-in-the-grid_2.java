class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int count = 0;
        for (int[] guard : guards) {
            for (int i = 0; i < 4; i++) {
                int x = guard[0] + dx[i];
                int y = guard[1] + dy[i];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1) {
                    if (grid[x][y] == 0) {
                        count++;
                        grid[x][y] = 2;
                    }
                    x += dx[i];
                    y += dy[i];
                }
            }
        }
        return count;
    }
}