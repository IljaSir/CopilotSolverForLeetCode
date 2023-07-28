class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int numLayer = Math.min(m, n) / 2;
        for (int layer = 0; layer < numLayer; layer++) {
            int[] nums = new int[(m - 2 * layer) * 2 + (n - 2 * layer) * 2 - 4];
            int idx = 0;
            for (int i = layer; i < n - layer; i++) {
                nums[idx++] = grid[layer][i];
            }
            for (int i = layer + 1; i < m - layer; i++) {
                nums[idx++] = grid[i][n - layer - 1];
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                nums[idx++] = grid[m - layer - 1][i];
            }
            for (int i = m - layer - 2; i > layer; i--) {
                nums[idx++] = grid[i][layer];
            }
            int shift = k % nums.length;
            idx = 0;
            for (int i = layer; i < n - layer; i++) {
                grid[layer][i] = nums[(idx - shift + nums.length) % nums.length];
                idx++;
            }
            for (int i = layer + 1; i < m - layer; i++) {
                grid[i][n - layer - 1] = nums[(idx - shift + nums.length) % nums.length];
                idx++;
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                grid[m - layer - 1][i] = nums[(idx - shift + nums.length) % nums.length];
                idx++;
            }
            for (int i = m - layer - 2; i > layer; i--) {
                grid[i][layer] = nums[(idx - shift + nums.length) % nums.length];
                idx++;
            }
        }
        return grid;
    }
}