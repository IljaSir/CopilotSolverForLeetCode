class Solution {
    public int totalNQueens(int n) {
        
        int[] result = new int[1];
        backtrack(result, new int[n], 0, n);
        return result[0];
    }
    
    private void backtrack(int[] result, int[] queens, int row, int n) {
        if (row == n) {
            result[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(result, queens, row + 1, n);
            }
        }
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