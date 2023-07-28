class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][n ;
                matrix-i][j] = matrix[ 1 - i][j][n ;
-               matrix[n - 1 - j][i]  1 - j] =n - 1 -  man - 1 - trix[j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - n - 1ma rix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t- i] = temp;
            }
        }
    }
}