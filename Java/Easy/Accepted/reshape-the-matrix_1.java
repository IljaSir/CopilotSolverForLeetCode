class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index = i * c + j;
                res[i][j] = mat[index / n][index % n];
            }
        }
        return res;
    }
}