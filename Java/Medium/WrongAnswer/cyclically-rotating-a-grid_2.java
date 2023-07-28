class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = grid[i][j];
            }
        }
        int r = 0;
        int c = 0;
        int min = Math.min(m, n);
        while (r < m && c < n) {
            if (r + 1 == m || c + 1 == n) {
                break;
            }
            int len = 2 * (m + n - 2 - 2 * r);
            int shift = k % len;
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = ans[i][j];
                }
            }
            for (int i = r; i < m - r - 1; i++) {
                int x = i - r;
                int y = c;
                ans[i][y] = tmp[(x + shift) % len + r][y];
            }
            for (int i = c; i < n - c - 1; i++) {
                int x = m - r - 1 - r;
                int y = i - c;
                ans[m - r - 1][i] = tmp[x + r][(y + shift) % len + c];
            }
            for (int i = m - r - 1; i > r; i--) {
                int x = m - r - 1 - i;
                int y = n - c - 1 - c;
                ans[i][n - c - 1] = tmp[(x + shift) % len + r][y + c];
            }
            for (int i = n - c - 1; i > c; i--) {
                int x = 0;
                int y = n - c - 1 - i;
                ans[r][i] = tmp[x + r][(y + shift) % len + c];
            }
            r++;
            c++;
        }
        return ans;
    }
}