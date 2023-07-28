class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int neg = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    neg++;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (neg % 2 == 1) {
            sum -= min * 2;
        }
        return sum;
    }
}