class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        int layer = 0;
        while (m - 2 * layer > 0 && n - 2 * layer > 0) {
            int[] items = new int[2 * (m - 2 * layer) + 2 * (n - 2 * layer) - 4];
            int index = 0;
            for (int i = layer; i < n - layer; i++) {
                items[index++] = grid[layer][i];
            }
            for (int i = layer + 1; i < m - layer; i++) {
                items[index++] = grid[i][n - layer - 1];
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                items[index++] = grid[m - layer - 1][i];
            }
            for (int i = m - layer - 2; i > layer; i--) {
                items[index++] = grid[i][layer];
            }
            int[] newItems = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                newItems[(i + k) % items.length] = items[i];
            }
            index = 0;
            for (int i = layer; i < n - layer; i++) {
                newGrid[layer][i] = newItems[index++];
            }
            for (int i = layer + 1; i < m - layer; i++) {
                newGrid[i][n - layer - 1] = newItems[index++];
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                newGrid[m - layer - 1][i] = newItems[index++];
            }
            for (int i = m - layer - 2; i > layer; i--) {
                newGrid[i][layer] = newItems[index++];
            }
            layer++;
        }
        return newGrid;
    }
}