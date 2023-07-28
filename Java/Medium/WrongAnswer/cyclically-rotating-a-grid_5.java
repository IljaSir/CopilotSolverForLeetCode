class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for (int i = 0; i < layers; i++) {
            int[] layer = new int[(m - 2 * i) * 2 + (n - 2 * i) * 2 - 4];
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
                grid[i][j] = newLayer[index++];
            }
            for (int j = i + 1; j < m - i; j++) {
                grid[j][n - i - 1] = newLayer[index++];
            }
            for (int j = n - i - 2; j >= i; j--) {
                grid[m - i - 1][j] = newLayer[index++];
            }
            for (int j = m - i - 2; j > i; j--) {
                grid[j][i] = newLayer[index++];
            }
        }
        return grid;
    }
}