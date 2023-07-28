class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    continue;
                }
                right[i][j] = (j == n - 1) ? 1 : right[i][j + 1] + 1;
                bottom[i][j] = (i == n - 1) ? 1 : bottom[i + 1][j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int min = Math.min(left[i][j], Math.min(right[i][j], Math.min(top[i][j], bottom[i][j])));
                max = Math.max(max, min);
            }
        }
        return max;
    }
}