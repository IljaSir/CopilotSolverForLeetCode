class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] diagonal = new int[n];
        for (int i = 0; i < n; i++) {
            diagonal[i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (diagonal[j] != matrix[i][j]) {
                    return false;
                }
            }
            for (int j = 0; j < n - 1; j++) {
                diagonal[j] = diagonal[j + 1];
            }
            diagonal[n - 1] = matrix[i][n - 1];
        }
        return true;
    }
}