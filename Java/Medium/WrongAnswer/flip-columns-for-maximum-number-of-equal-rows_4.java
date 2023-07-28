class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int count = 1;
            for (int j = i + 1; j < m; j++) {
                int k = 0;
                while (k < n && (matrix[i][k] == matrix[j][k] || matrix[i][k] == 1 - matrix[j][k])) {
                    k++;
                }
                if (k == n) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}