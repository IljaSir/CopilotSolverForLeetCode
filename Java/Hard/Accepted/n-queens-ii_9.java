class Solution {
    public int totalNQueens(int n) {
        
        if (n <= 0) {
            return 0;
        }
        int[] result = new int[1];
        int[] queens = new int[n];
        placeQueens(queens, 0, n, result);
        return result[0];
    }

    private void placeQueens(int[] queens, int row, int n, int[] result) {
        if (row == n) {
            result[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                placeQueens(queens, row + 1, n, result);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            if (row - i == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
}