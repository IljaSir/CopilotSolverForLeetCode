class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = 0;
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;
        for (int i = 0; i < cells.length; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
            if (x == 0) {
                grid[x][y] = 2;
            }
            for (int j = 0; j < 4; j++) {
                int tx = x + dx[j];
                int ty = y + dy[j];
                if (tx < 0 || tx >= row || ty < 0 || ty >= col) {
                    continue;
                }
                if (grid[tx][ty] == 2) {
                    grid[x][y] = 2;
                }
            }
            if (grid[x][y] == 2) {
                for (int j = 0; j < 4; j++) {
                    int tx = x + dx[j];
                    int ty = y + dy[j];
                    if (tx < 0 || tx >= row || ty < 0 || ty >= col) {
                        continue;
                    }
                    if (grid[tx][ty] == 2) {
                        continue;
                    }
                    if (grid[tx][ty] == 1) {
                        grid[tx][ty] = 2;
                    }
                }
            }
            boolean flag = true;
            for (int j = 0; j < col; j++) {
                if (grid[row - 1][j] != 2) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = i + 1;
            }
        }
        return ans;
    }
}