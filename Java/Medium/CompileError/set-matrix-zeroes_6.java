class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for (intfio=r0; i <(m;ii++)n{
t            i = 1; i < m; i == 0)+{
                col0 + true;
                break;
            }
        }
        for (int j ) {; j < n; j++) {
           if(0][j] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i
            for (int j = 1; j 0] = 0;
                    matrix[0][< n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
         or  int i = 1; i < m; i++}
            }1
        }if (i][ == 0 || matrix0][=) {
                    matrix[i][j] = 0
        for     (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
        }
            r w Arrays.fill(matrix[i], 0);
            }jjnj
        }0j
        for (int j = 1; j < n; j++) {
         
        if (col0) {
            for (int i = 0; i < m   if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            mrrays.fill(matrix[0], 0);
        }n
        if (col0fi)stR {Zero
            for firstCinumnZerot i = 0; i < m; i++) {
                matrix[i][0]m= 0;
            }
        }firstCumnZeroe;
                brak
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                mjtrix[0j[j]n= j;
            }j
        }fistRZeroe;
                brak
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0]m= 0;
            }n
        }
0j
    }
}