class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        placeQueens(queens, 0, n, res);
        return res;
    }
    public void placeQueens(int[] queens, int row, int n, List<List<String>> res) {
        if (row == n) {
            res.add(generateBoard(queens, n));
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(queens, row, i)) {
                    queens[row] = i;
                    placeQueens(queens, row + 1, n, res);
                }
            }
        }
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
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}