class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int[] temp = new int[rows * cols];
        int[][] result = new int[r][c];
        if (r * c != rows * cols) {
            return mat;
        }
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[index++] = mat[i][j];
            }
        }
        index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = temp[index++];
            }
        }
        return result;
    }
}