class Solution {
    public boolean checkValid(int[][] matrix) {
        
        // Check every row
        for (int i = 0; i < matrix.length; i++) {
            if (!checkRow(matrix, i)) {
                return false;
            }
        }

        // Check every column
        for (int i = 0; i < matrix.length; i++) {
            if (!checkCol(matrix, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkRow(int[][] matrix, int row) {
        boolean[] seen = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (seen[matrix[row][i] - 1]) {
                return false;
            }
            seen[matrix[row][i] - 1] = true;
        }
        return true;
    }

    public boolean checkCol(int[][] matrix, int col) {
        boolean[] seen = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (seen[matrix[i][col] - 1]) {
                return false;
            }
            seen[matrix[i][col] - 1] = true;
        }
        return true;
    }
}