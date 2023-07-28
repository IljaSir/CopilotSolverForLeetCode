class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] row0 = new long[n+1];
        long[] row1 = new long[n+1];
        long[] sum0 = new long[n+1];
        long[] sum1 = new long[n+1];
        for (int i = 0; i < n; i++) {
            row0[i+1] = grid[0][i];
            row1[i+1] = grid[1][i];
            sum0[i+1] = sum0[i] + grid[0][i];
            sum1[i+1] = sum1[i] + grid[1][i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long score = 0;
            long left = sum0[i];
            long right = sum1[n] - sum1[i+1];
            score = Math.max(score, left + right);
            left = sum0[n] - sum0[i+1];
            right = sum1[i];
            score = Math.max(score, left + right);
            min = Math.min(min, score);
        }
        return min;
    }
}