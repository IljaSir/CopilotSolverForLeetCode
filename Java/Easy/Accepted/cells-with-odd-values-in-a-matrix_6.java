class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] idx : indices) {
            rows[idx[0]]++;
            cols[idx[1]]++;
        }
        int oddRows = 0;
        int oddCols = 0;
        for (int i = 0; i < m; i++) {
            if (rows[i] % 2 == 1) {
                oddRows++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] % 2 == 1) {
                oddCols++;
            }
        }
        return oddRows * n + oddCols * m - 2 * oddRows * oddCols;
    }
}