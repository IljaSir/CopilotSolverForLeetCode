class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][] left = new int[n][m];
        int[][] top = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                    top[i][j] = i == 0 ? 1 : top[i - 1][j] + 1;
                }
            }
        }
        for (int size = Math.min(n, m); size > 0; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    if (top[i + size - 1][j] >= size && left[i][j + size - 1] >= size && top[i][j] >= size && left[i + size - 1][j] >= size) {
                        return size * size;
                    }
                }
            }
        }
        return 0;
    }
}