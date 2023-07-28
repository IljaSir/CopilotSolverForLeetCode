class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (grid[nx][ny] == grid[x][y] + 1) {
                            x = nx;
                            y = ny;
                        }
                    }
                }
                if (x != n - 1 || y != m - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}