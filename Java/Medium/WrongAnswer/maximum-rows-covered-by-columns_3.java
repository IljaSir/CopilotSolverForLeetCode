class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    mask |= (1 << j);
                }
            }
            for (int j = 0; j < (1 << n); j++) {
                if ((j & mask) == mask) {
                    dp[j] += 1;
                }
            }
        }
        int[] dp2 = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (Integer.bitCount(j) == numSelect) {
                    dp2[i] = Math.max(dp2[i], dp2[i ^ j] + dp[j]);
                }
            }
        }
        return dp2[(1 << n) - 1];
    }
}