class Solution {
    public int totalNQueens(int n) {
        
        int[] result = new int[1];
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
        solveNQueens(0, queens, result);
        return result[0];
    }
    private void solveNQueens(int row, int[] queens, int[] result) {
        int n = queens.length;
        if (row == n) {
            result[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                solveNQueens(row + 1, queens, result);
                queens[row] = -1;
            }
        }
    }
    private boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}