class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] top = new int[m][n];
        int[][] right = new int[m][n];
        int[][] bottom = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                    top[i][j] = i == 0 ? 1 : top[i - 1][j] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = j == n - 1 ? 1 : right[i][j + 1] + 1;
                    bottom[i][j] = i == m - 1 ? 1 : bottom[i + 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(left[i][j], top[i][j]);
                for (int k = min; k >= 1; k--) {
                    if (right[i][j] >= k && bottom[i][j] >= k) {
                        max = Math.max(max, k);
                        break;
                    }
                }
            }
        }
        return max * max;
    }
}