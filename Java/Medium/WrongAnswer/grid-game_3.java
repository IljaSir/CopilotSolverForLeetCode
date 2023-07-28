class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] left = new long[n];
        long[] right = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            left[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += grid[1][i];
            right[i] = sum;
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, Math.max(left[i], right[i + 1]));
        }
        return min;
    }
}