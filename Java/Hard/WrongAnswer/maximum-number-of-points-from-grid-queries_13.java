class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int q = queries[i];
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    int max = 0;
                    for (int k = 1; k <= Math.min(r, c); k++) {
                        int tmp = preSum[r][c] - preSum[r - k][c] - preSum[r][c - k] + preSum[r - k][c - k];
                        if (tmp <= q) {
                            max = k;
                        } else {
                            break;
                        }
                    }
                    res[i] = Math.max(res[i], max);
                }
            }
        }
        return res;
    }
}