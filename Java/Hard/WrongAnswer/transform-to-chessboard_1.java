class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = (row[i] << 1) | board[i][j];
                col[j] = (col[j] << 1) | board[i][j];
            }
        }
        return helper(row) + helper(col);
    }

    private int helper(int[] arr) {
        int n = arr.length;
        int mask = (1 << n) - 1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int num = arr[j] ^ arr[(j + i) % n];
                while (num > 0) {
                    count += num & 1;
                    num >>= 1;
                }
            }
            if (count < res) {
                res = count;
                if (count == 0) {
                    break;
                }
            }
        }
        return res;
    }
}