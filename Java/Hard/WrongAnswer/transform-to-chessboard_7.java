class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int rowDiff = 0;
        int colDiff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            rows[i] = board[0][i];
            cols[i] = board[i][0];
            rowDiff += rows[i] == i % 2 ? 1 : -1;
            colDiff += cols[i] == i % 2 ? 1 : -1;
        }
        if (Math.abs(rowDiff) > 1 || Math.abs(colDiff) > 1) {
            return -1;
        }
        if (n % 2 == 1) {
            if (rowDiff == 1) {
                rowDiff = -1;
            }
            if (colDiff == 1) {
                colDiff = -1;
            }
        } else {
            rowDiff = Math.max(rowDiff, -rowDiff);
            colDiff = Math.max(colDiff, -colDiff);
        }
        return (rowDiff + colDiff) / 2;
    }
}