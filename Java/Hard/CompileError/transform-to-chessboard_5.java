class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int[] rowSwap = new int[n];
        int[] colSwap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j] == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += board[i][j];
                colSum[j] += board[i][j];
                if (board[i][j] == i % 2) {
                    rowSwap[i]++;
                }
                if (board[j][i] == i % 2) {
                    colSwap[i]++;
                }
            }
            if (rowSum[i] < n / 2 || rowSum[i] > (n + 1) / 2) {
                return -1;
            }
            if (colSum[i] < n / 2 || colSum[i] > (n + 1) / 2) {
                return -1;
            }
        }
        int rowSwapCount = 0;
        int colSwapCount = 0;
        for (int i = 0; i < n; i++) {
            if (n % 2 == 1) {
                if (rowSwap[i] % 2 == 1) {
                    rowSwapCount += Math.min(rowSwap[i], n - rowSwap[i]);
                }
                if (colSwap[i] % 2 == 1) {
                    colSwapCount += Math.min(colSwap[i], n - colSwap[i]);
                }
            } else {
                rowSwapCount += Math.min(rowSwap[i], n - rowSwap[i]);
                colSwapCount += Math.min(colSwap[i], n - colSwap[i]);
            }
        }
        return (rowSwapCount + colSwapCount) / 2;
    }
}