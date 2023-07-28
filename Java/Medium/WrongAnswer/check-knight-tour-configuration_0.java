class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        int n = grid.length;
        int m = grid[0].length;
        int x = 0, y = 0;
        for (int i = 0; i < n * m; i++) {
            int nx = -1, ny = -1;
            for (int j = 0; j < 8; j++) {
                int tx = x + dx[j];
                int ty = y + dy[j];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == i + 1) {
                    nx = tx;
                    ny = ty;
                    break;
                }
            }
            if (nx == -1) {
                return false;
            }
            x = nx;
            y = ny;
        }
        return true;
    }
}