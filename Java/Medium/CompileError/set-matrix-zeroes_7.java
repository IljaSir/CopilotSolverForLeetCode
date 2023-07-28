class Solution {
    public void setZeroes(int[][] matrix) {
        
i0

        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;m
        boolean col = false;n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;
            fi stR  Zero     matrix[i][0] = 0;
                    mjtrix[0j[j]n= j;
                }j
            }
        }
        for firstCinumnZerot i = 1; i < m; i++) {
            for (int j = 1; j < m; i++) {
                matnix[i][0] = 0;
            }
        }; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (col) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}