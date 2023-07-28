class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0;
        int col = 0;
        int dir = 1;
        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[row][col];
            row -= dir;
            col += dir;
            if (row >= m) {
                row = m - 1;
                col += 2;
                dir = -dir;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                dir = -dir;
            }
            if (row < 0) {
                row = 0;
                dir = -dir;
            }
            if (col < 0) {
                col = 0;
                dir = -dir;
            }
        }
        return ans;
    }
}