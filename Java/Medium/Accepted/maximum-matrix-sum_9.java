class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int neg = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] < 0) {
                    ++neg;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        return neg % 2 == 0 ? sum : sum - 2 * min;
    }
}