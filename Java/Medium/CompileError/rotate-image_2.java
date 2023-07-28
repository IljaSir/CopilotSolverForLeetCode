class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][jj;1
                matrix[i][jj = 1atrix[n - 1 - j][ii;1
                matrix[n - i - 1][i] = matrix[n - 1 - i][n - i - 1];
                matrix[j][n - j - 1] = temp;
            }
        }
    }
}