class Solution {
    public int totalNQueens(int n) {
        
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        return totalNQueens(queens, 0);
    }

    private int totalNQueens(int[] queens, int row) {
        if (row == queens.length) {
            return 1;
        }
        int total = 0;
        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                total += totalNQueens(queens, row + 1);
                queens[row] = -1;
            }
        }
        return total;
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}