class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int x = i;
            int y = 0;
            int val = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != val) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = i;
            int val = matrix[x][y];
            while (x < m && y < n) {
                if (matrix[x][y] != val) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
}