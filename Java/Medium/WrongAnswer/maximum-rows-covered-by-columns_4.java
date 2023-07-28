class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length, n = matrix[0].length;
        int[] rowMask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMask[i] |= matrix[i][j] << j;
            }
        }
        int[] dp = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < m; i++) {
                if ((rowMask[i] & mask) == rowMask[i]) {
                    dp[mask]++;
                }
            }
        }
        int[] max = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            max[mask] = dp[mask];
            for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                if (Integer.bitCount(sub) == numSelect) {
                    max[mask] = Math.max(max[mask], max[mask ^ sub] + dp[sub]);
                }
            }
        }
        return max[(1 << n) - 1];
    }
}