class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] row = new boolean[n];
            boolean[] column = new boolean[n];
            for (int j = 0; j < n; j++) {
                row[matrix[i][j] - 1] = true;
                column[matrix[j][i] - 1] = true;
            }
            if (!check(row) || !check(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(boolean[] row) {
        for (boolean b : row) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}