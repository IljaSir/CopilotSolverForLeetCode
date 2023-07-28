class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] preSum = new long[n];
        preSum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + grid[0][i];
        }
        long[] sufSum = new long[n];
        sufSum[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + grid[1][i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, Math.max(preSum[i], sufSum[i + 1]));
        }
        return res;
    }
}