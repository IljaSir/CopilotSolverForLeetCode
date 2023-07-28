class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
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