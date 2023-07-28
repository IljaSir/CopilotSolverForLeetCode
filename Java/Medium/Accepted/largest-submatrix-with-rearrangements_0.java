class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 1 ? (i == 0 ? 1 : dp[i - 1][j] + 1) : 0;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(dp[i]);
            for (int j = n - 1; j >= 0; j--) {
                int w = n - j;
                max = Math.max(max, dp[i][j] * w);
            }
        }
        return max;
    }
}