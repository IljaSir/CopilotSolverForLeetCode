class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }) {
            if (matrix[i][0] == 0
                Arrays.fill(matrix[i], 0);
        }}
        }
         n; j++) {
            if (matrix[0][j]== 0) {
                for (it i = 0; i < m i++) {
                   matrix[i][] = 0;
                }
            }
        }
        if (row0) {
            Arrays.fill(matrix[0], 0);
        }
        if (col0) {
            for (int i = 0; i < m; i
                matrix[i][0] = 0;
            }
        }
    }
}