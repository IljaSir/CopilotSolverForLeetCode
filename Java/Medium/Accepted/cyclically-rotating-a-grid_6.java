class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        int layers = Math.min(n, m) / 2;
        int[][] res = new int[n][m];
        for (int i = 0; i < layers; i++) {
            int len = 2 * (n - i * 2) + 2 * (m - i * 2) - 4;
            int[] tmp = new int[len];
            int idx = 0;
            for (int j = i; j < m - i; j++) {
                tmp[idx++] = grid[i][j];
            }
            for (int j = i + 1; j < n - i; j++) {
                tmp[idx++] = grid[j][m - i - 1];
            }
            for (int j = m - i - 2; j >= i; j--) {
                tmp[idx++] = grid[n - i - 1][j];
            }
            for (int j = n - i - 2; j > i; j--) {
                tmp[idx++] = grid[j][i];
            }
            int start = k % len;
            idx = 0;
            for (int j = i; j < m - i; j++) {
                res[i][j] = tmp[start++];
                if (start == len) {
                    start = 0;
                }
            }
            for (int j = i + 1; j < n - i; j++) {
                res[j][m - i - 1] = tmp[start++];
                if (start == len) {
                    start = 0;
                }
            }
            for (int j = m - i - 2; j >= i; j--) {
                res[n - i - 1][j] = tmp[start++];
                if (start == len) {
                    start = 0;
                }
            }
            for (int j = n - i - 2; j > i; j--) {
                res[j][i] = tmp[start++];
                if (start == len) {
                    start = 0;
                }
            }
        }
        return res;
    }
}