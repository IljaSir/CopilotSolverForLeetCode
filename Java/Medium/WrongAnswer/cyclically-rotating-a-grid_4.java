class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int layers = Math.min(m, n) / 2;
        for (int i = 0; i < layers; i++) {
            int[] layer = new int[(m - i * 2) * 2 + (n - i * 2) * 2 - 4];
            int index = 0;
            for (int j = i; j < n - i; j++) {
                layer[index++] = grid[i][j];
            }
            for (int j = i + 1; j < m - i; j++) {
                layer[index++] = grid[j][n - i - 1];
            }
            for (int j = n - i - 2; j >= i; j--) {
                layer[index++] = grid[m - i - 1][j];
            }
            for (int j = m - i - 2; j > i; j--) {
                layer[index++] = grid[j][i];
            }
            int[] newLayer = new int[layer.length];
            for (int j = 0; j < layer.length; j++) {
                newLayer[(j + k) % layer.length] = layer[j];
            }
            index = 0;
            for (int j = i; j < n - i; j++) {
                res[i][j] = newLayer[index++];
            }
            for (int j = i + 1; j < m - i; j++) {
                res[j][n - i - 1] = newLayer[index++];
            }
            for (int j = n - i - 2; j >= i; j--) {
                res[m - i - 1][j] = newLayer[index++];
            }
            for (int j = m - i - 2; j > i; j--) {
                res[j][i] = newLayer[index++];
            }
        }
        return res;
    }
}