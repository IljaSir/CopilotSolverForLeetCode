class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }
        return min;
    }
}