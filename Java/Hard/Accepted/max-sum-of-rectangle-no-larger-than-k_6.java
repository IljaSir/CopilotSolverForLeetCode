class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        int sum = preSum[p][q] - preSum[i - 1][q] - preSum[p][j - 1] + preSum[i - 1][j - 1];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
        return max;
    }
}