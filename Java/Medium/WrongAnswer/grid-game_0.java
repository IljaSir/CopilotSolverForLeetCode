class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] sum = new long[n];
        sum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        long res = Long.MAX_VALUE;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                cur += grid[1][i - 1];
            }
            if (i < n - 1) {
                res = Math.min(res, Math.max(cur, sum[n - 1] - sum[i] - grid[0][i]));
            }
        }
        return res;
    }
}