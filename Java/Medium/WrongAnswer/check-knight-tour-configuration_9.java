class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[] dirs = {1, 2, 2, 1, -1, -2, -2, -1};
        boolean[][] visited = new boolean[n][n];
        int i = 0, j = 0;
        for (int k = 0; k < n * n; k++) {
            if (grid[i][j] != k) {
                return false;
            }
            visited[i][j] = true;
            for (int d = 0; d < 8; d += 2) {
                int x = i + dirs[d];
                int y = j + dirs[d + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    i = x;
                    j = y;
                    break;
                }
            }
        }
        return true;
    }
}