class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solveNQueens(0, queens, result);
        return result;
    }
    
    public void solveNQueens(int row, int[] queens, List<List<String>> result) {
        int n = queens.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowChars = new char[n];
                Arrays.fill(rowChars, '.');
                rowChars[queens[i]] = 'Q';
                solution.add(new String(rowChars));
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                solveNQueens(row + 1, queens, result);
            }
        }
    }
    
    public boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}