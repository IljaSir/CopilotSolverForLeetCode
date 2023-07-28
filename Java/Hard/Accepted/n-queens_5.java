class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solveNQueens(result, queens, 0);
        return result;
    }
    
    private void solveNQueens(List<List<String>> result, int[] queens, int row) {
        int n = queens.length;
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                ch[queens[i]] = 'Q';
                list.add(new String(ch));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(queens, row, i)) {
                queens[row] = i;
                solveNQueens(result, queens, row + 1);
                queens[row] = -1;
            }
        }
    }
    
    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}