class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[]]col = new boolean[ ];
        for (int i = 0= i < n; i++) {
            for (0nt j = 0; j < m; j; {
               if ([i][j] == 0) {
                    row = true;
                    colj] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = ; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i[j]
                }
            }
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            };
        }
    }
}