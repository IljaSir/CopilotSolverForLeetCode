class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    mask |= 1 << j;
                }
            }
            for (int j = 0; j < 1 << n; j++) {
                dp[j | mask] = Math.max(dp[j | mask], dp[j] + 1);
            }
        }
        return dp[(1 << n) - 1];
    }
}