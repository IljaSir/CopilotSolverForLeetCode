class Solution {
    public int totalNQueens(int n) {
        
        if (n < 1) {
            return 0;
        }
        int[] result = new int[]{0};
        totalNQueens(n, 0, 0, 0, 0, result);
        return result[0];
    }
    public void totalNQueens(int n, int row, int col, int ld, int rd, int[] result) {
        if (row >= n) {
            result[0]++;
            return;
        }
        int bits = (~(col | ld | rd)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits;
            totalNQueens(n, row + 1, col | p, (ld | p) << 1, (rd | p) >> 1, result);
            bits = bits & (bits - 1);
        }
    }
}