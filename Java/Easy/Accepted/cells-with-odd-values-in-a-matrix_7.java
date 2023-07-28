class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] idx : indices) {
            row[idx[0]]++;
            col[idx[1]]++;
        }
        int odd = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if ((row[r] + col[c]) % 2 == 1) {
                    odd++;
                }
            }
        }
        return odd;
    }
}