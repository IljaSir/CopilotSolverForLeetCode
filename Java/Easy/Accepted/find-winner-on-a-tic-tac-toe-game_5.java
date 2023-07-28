class Solution {
    public String tictactoe(int[][] moves) {
        
        int[] row = new int[3];
        int[] col = new int[3];
        int diag = 0, antidiag = 0;
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            int r = moves[i][0], c = moves[i][1];
            int player = i % 2 == 0 ? 1 : -1;
            row[r] += player;
            col[c] += player;
            if (r == c) {
                diag += player;
            }
            if (r + c == 2) {
                antidiag += player;
            }
            if (Math.abs(row[r]) == 3 || Math.abs(col[c]) == 3 || Math.abs(diag) == 3 || Math.abs(antidiag) == 3) {
                return i % 2 == 0 ? "A" : "B";
            }
        }
        return n == 9 ? "Draw" : "Pending";
    }
}