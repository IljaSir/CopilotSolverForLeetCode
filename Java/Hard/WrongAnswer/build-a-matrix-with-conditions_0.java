class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < rowConditions.length; i++) {
            matrix[rowConditions[i][0] - 1][rowConditions[i][1] - 1] = 1;
            matrix[rowConditions[i][1] - 1][rowConditions[i][0] - 1] = 1;
        }
        for (int i = 0; i < colConditions.length; i++) {
            matrix[colConditions[i][0] - 1][colConditions[i][1] - 1] = 1;
            matrix[colConditions[i][1] - 1][colConditions[i][0] - 1] = 1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = 3;
                }
            }
        }
        return matrix;
    }
}