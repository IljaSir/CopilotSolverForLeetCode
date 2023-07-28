class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = true;
                }
                if (matrix[j][i] == 1) {
                    col[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!row[i] || !col[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkValid2(int[][] matrix) {
        int n = matrix.length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = true;
                }
                if (matrix[j][i] == 1) {
                    col[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!row[i] || !col[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkValid3(int[][] matrix) {
        int n = matrix.length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = true;
                }
                if (matrix[j][i] == 1) {
                    col[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!row[i] || !col[i]) {
                return false;
            }
        }
        return true;
    }
}