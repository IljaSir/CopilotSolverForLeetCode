class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                row[i] |= 1 << num;
                col[j] |= 1 << num;
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] != (1 << n) - 1) {
                return false;
            }
            if (col[i] != (1 << n) - 1) {
                return false;
            }
        }
        return true;
    }
}