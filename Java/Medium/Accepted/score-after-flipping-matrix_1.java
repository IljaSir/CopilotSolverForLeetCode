class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int res = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) {
                    nOnes += grid[i][j];
                } else {
                    nOnes += (1 - grid[i][j]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            res += k * (1 << (n - j - 1));
        }
        return res;
    }
}