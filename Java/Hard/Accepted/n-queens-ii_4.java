class Solution {
    public int totalNQueens(int n) {
        
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        return totalNQueens(queens, 0);
    }
    public int totalNQueens(int[] queens, int row) {
        int n = queens.length;
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                count += totalNQueens(queens, row + 1);
            }
        }
        return count;
    }
    public boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}