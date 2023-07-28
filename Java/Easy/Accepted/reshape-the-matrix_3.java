class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                int newI = index / c;
                int newJ = index % c;
                result[newI][newJ] = mat[i][j];
            }
        }
        return result;
    }
}