class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] count = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[i] += grid[i][j];
            }
        }
        int total = m * n;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (check(grid, i, j, stampHeight, stampWidth)) {
                    total -= stampHeight * stampWidth;
                    visited[i] = true;
                    if (total == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int[][] grid, int i, int j, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int k = i; k < i + stampHeight; k++) {
            for (int l = j; l < j + stampWidth; l++) {
                if (k >= m || l >= n) {
                    return false;
                }
                if (grid[k][l] == 0) {
                    total++;
                }
            }
        }
        return total == stampHeight * stampWidth;
    }
}