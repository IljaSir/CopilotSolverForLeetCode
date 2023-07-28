class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for (int i = 0; i < layers; i++) {
            int[] tmp = new int[(m - 2 * i) * 2 + (n - 2 * i) * 2 - 4];
            int index = 0;
            for (int j = i; j < n - i; j++) {
                tmp[index++] = grid[i][j];
            }
            for (int j = i + 1; j < m - i; j++) {
                tmp[index++] = grid[j][n - i - 1];
            }
            for (int j = n - i - 2; j >= i; j--) {
                tmp[index++] = grid[m - i - 1][j];
            }
            for (int j = m - i - 2; j > i; j--) {
                tmp[index++] = grid[j][i];
            }
            int[] tmp2 = new int[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                tmp2[(j + k) % tmp.length] = tmp[j];
            }
            index = 0;
            for (int j = i; j < n - i; j++) {
                grid[i][j] = tmp2[index++];
            }
            for (int j = i + 1; j < m - i; j++) {
                grid[j][n - i - 1] = tmp2[index++];
            }
            for (int j = n - i - 2; j >= i; j--) {
                grid[m - i - 1][j] = tmp2[index++];
            }
            for (int j = m - i - 2; j > i; j--) {
                grid[j][i] = tmp2[index++];
            }
        }
        return grid;
    }
}