class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] sum = new long[n];
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = grid[0][i] + grid[1][i];
        }
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + sum[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + sum[i + 1];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, Math.max(left[i], right[i]));
        }
        return res;
    }
}