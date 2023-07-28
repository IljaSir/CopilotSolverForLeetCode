class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] |= (1 << matrix[i][j]);
                col[j] |= 1 << matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] != ((1 << (n + 1)) - 2) || col[i] != ((1 << (n + 1)) - 2)) {
                return false;
            }
        }
        return true;
    }
}