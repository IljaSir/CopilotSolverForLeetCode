class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    count++;
                }
            }
            sum += Math.max(count, m - count) * (1 << (n - i - 1));
        }
        return sum;
    }
}