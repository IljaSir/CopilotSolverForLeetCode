class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[][] matrix = new int[k][k];
        for (int[] row: matrix) {
            Arrays.fill(row, 1);
        }
        for (int[] rowCondition: rowConditions) {
            int above = rowCondition[0] - 1;
            int below = rowCondition[1] - 1;
            for (int i = 0; i < k; i++) {
                if (i < above || i > below) {
                    matrix[i][below] = 0;
                }
            }
        }
        for (int[] colCondition: colConditions) {
            int left = colCondition[0] - 1;
            int right = colCondition[1] - 1;
            for (int i = 0; i < k; i++) {
                if (i < left || i > right) {
                    matrix[right][i] = 0;
                }
            }
        }
        int counter = k;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = counter;
                    counter++;
                }
            }
        }
        return matrix;
    }
}