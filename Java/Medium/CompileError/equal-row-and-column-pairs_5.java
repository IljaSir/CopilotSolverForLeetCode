class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j] = grid[i][j];
                col[i][j] = grid[j][i];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Arrays.equals(row[i], row[j])) {
                    res++;
                }
                if (Arrays.equals(col[i], col[j])) {
                    res++;
                }
            }
        }
        return res;
    }
}
    }
}