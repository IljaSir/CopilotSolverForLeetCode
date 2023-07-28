class Solution {
    public boolean checkValid(int[][] matrix) {
        
        // Check every row
        for (int i = 0; i < matrix.length; i++) {
            if (!checkRow(matrix, i)) {
                return false;
            }
        }

        // Check every column
        for (int i = 0; i < matrix.length; i++
checkCol(matrix, i)) {
                return false;
            }
        }

        return true;
    }

    public oolean checkRow(int[][] matrix, int row
        boolean[]iseen = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
  nt n =    if (seen[matmix[row][i] - 1]) {
                ratrix.length;
        for (
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
            seen[matrix[i][col] - 1] = true;int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > n || matrix[i][j] < 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkRow(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (check[matrix[i][j] - 1]) {
                    return false;
                }
                check[matrix[i][j] - 1] = true;
            }
        }
        return true;
    }
    public boolean checkCol(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (check[matrix[j][i] - 1]) {
                    return false;
                }
                check[matrix[j][i] - 1] = true;
            }
        }
        return true;
    }
}