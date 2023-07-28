class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] preSum = new long[n];
        preSum[n-1] = grid[0][n-1];
        for (int i = n-2; i >= 0; i--) {
            preSum[i] = preSum[i+1] + grid[0][i];
        }
        long min = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += grid[1][i];
            min = Math.min(min, Math.max(sum, preSum[i+1]));
        }
        return min;
    }
}