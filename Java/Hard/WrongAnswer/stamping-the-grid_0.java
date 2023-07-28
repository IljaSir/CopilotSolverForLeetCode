class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] stamp = new int[stampHeight][stampWidth];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < stampHeight && j < stampWidth) {
                    stamp[i][j] = grid[i][j];
                }
                grid[i][j] = 1;
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        if (i + stampHeight <= m && j + stampWidth <= n) {
                            if (isMatched(grid, i, j, stamp)) {
                                flag = true;
                                for (int k = 0; k < stampHeight; k++) {
                                    for (int l = 0; l < stampWidth; l++) {
                                        grid[i + k][j + l] = stamp[k][l];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMatched(int[][] grid, int i, int j, int[][] stamp) {
        int m = stamp.length;
        int n = stamp[0].length;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (grid[i + k][j + l] == 1 && stamp[k][l] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}