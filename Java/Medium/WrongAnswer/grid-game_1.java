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
        long ans = sufSum[0];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            if (i - 1 >= 0) {
                sum += preSum[i - 1];
            }
            if (i + 1 < n) {
                sum += sufSum[i + 1];
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}