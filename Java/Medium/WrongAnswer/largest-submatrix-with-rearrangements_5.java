class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + 1;
                }
            }
            Arrays.sort(dp);
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[j] * (n - j));
            }
        }
        return res;
    }
}