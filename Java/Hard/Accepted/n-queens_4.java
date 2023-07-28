class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(res, queens, 0, n);
        return res;
    }
    
    private void backtrack(List<List<String>> res, int[] queens, int row, int n) {
        if (row == n) {
            res.add(convert(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(res, queens, row + 1, n);
                queens[row] = -1;
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
    
    private List<String> convert(int[] queens, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
}