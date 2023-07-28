class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        long sum = 0;
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                sum += Math.abs(v);
                min = Math.min(min, Math.abs(v));
                if (v < 0) {
                    negativeCount++;
                }
            }
        }
        if (negativeCount % 2 == 1) {
            sum -= 2 * min;
        }
        return sum;
    }
}