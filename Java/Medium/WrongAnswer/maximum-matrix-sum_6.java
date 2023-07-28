class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int n = matrix.length;
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    neg++;
                }
            }
        }
        if (n % 2 == 0 || neg % 2 == 0) {
            return ans;
        }
        return ans - 2 * min;
    }
}