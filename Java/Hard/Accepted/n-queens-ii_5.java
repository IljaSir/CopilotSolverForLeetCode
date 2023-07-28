class Solution {
    public int totalNQueens(int n) {
        
        int[] result = new int[1];
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        placeQueen(queens, 0, result);
        return result[0];
    }
    
    private void placeQueen(int[] queens, int row, int[] result) {
        if (row == queens.length) {
            result[0]++;
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                placeQueen(queens, row + 1, result);
            }
        }
    }
    
    private boolean isValid(int[] queens, int row, int col) {
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