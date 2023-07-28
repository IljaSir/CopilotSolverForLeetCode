class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[] dirs = {2, 1, -2, -1, 2};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j] / n;
                int y = grid[i][j] % n;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dirs[k];
                    int ny = j + dirs[k + 1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        int nx2 = grid[nx][ny] / n;
                        int ny2 = grid[nx][ny] % n;
                        if (Math.abs(nx2 - x) + Math.abs(ny2 - y) != 3) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}