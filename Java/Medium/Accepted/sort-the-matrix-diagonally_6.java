class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int[] diag = new int[Math.min(m - i, n)];
            for (int j = 0; j < diag.length; j++) {
                diag[j] = mat[i + j][j];
            }
            Arrays.sort(diag);
            for (int j = 0; j < diag.length; j++) {
                mat[i + j][j] = diag[j];
            }
        }
        for (int j = 1; j < n; j++) {
            int[] diag = new int[Math.min(n - j, m)];
            for (int i = 0; i < diag.length; i++) {
                diag[i] = mat[i][j + i];
            }
            Arrays.sort(diag);
            for (int i = 0; i < diag.length; i++) {
                mat[i][j + i] = diag[i];
            }
        }
        return mat;
    }
}