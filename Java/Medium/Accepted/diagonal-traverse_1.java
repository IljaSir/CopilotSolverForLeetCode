class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[row][col];
            if ((row + col) % 2 == 0) { // moving up
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else { row--; col++; }
            } else { // moving down
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else { row++; col--; }
            }
        }
        return res;
    }
}