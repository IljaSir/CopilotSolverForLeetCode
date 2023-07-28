class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int min = Math.min(m, n) / 2;
        int[][] ans = new int[m][n];
        for (int i = 0; i < min; i++) {
            int[] tmp = new int[2 * (m - 2 * i) + 2 * (n - 2 * i) - 4];
            int idx = 0;
            for (int j = i; j < n - i; j++) {
                tmp[idx++] = grid[i][j];
            }
            for (int j = i + 1; j < m - i; j++) {
                tmp[idx++] = grid[j][n - i - 1];
            }
            for (int j = n - i - 2; j >= i; j--) {
                tmp[idx++] = grid[m - i - 1][j];
            }
            for (int j = m - i - 2; j > i; j--) {
                tmp[idx++] = grid[j][i];
            }
            int[] rot = new int[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                rot[(j + k) % tmp.length] = tmp[j];
            }
            idx = 0;
            for (int j = i; j < n - i; j++) {
                ans[i][j] = rot[idx++];
            }
            for (int j = i + 1; j < m - i; j++) {
                ans[j][n - i - 1] = rot[idx++];
            }
            for (int j = n - i - 2; j >= i; j--) {
                ans[m - i - 1][j] = rot[idx++];
            }
            for (int j = m - i - 2; j > i; j--) {
                ans[j][i] = rot[idx++];
            }
        }
        return ans;
    }
}