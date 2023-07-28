class Solution {
    public int totalNQueens(int n) {
        
        int[] res = new int[1];
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        dfs(queens, 0, res);
        return res[0];
    }
    private void dfs(int[] queens, int row, int[] res) {
        if (row == queens.length) {
            res[0]++;
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            if (isValid(queens, row, i)) {
                queens[row] = i;
                dfs(queens, row + 1, res);
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
}