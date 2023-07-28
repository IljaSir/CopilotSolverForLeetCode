class Solution {
    public int totalNQueens(int n) {
        
        int[] res = {0};
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        dfs(n, 0, res, col, dia1, dia2);
        return res[0];
    }
    private void dfs(int n, int row, int[] res, boolean[] col, boolean[] dia1, boolean[] dia2) {
        if (row == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[row + i] && !dia2[row - i + n - 1]) {
                col[i] = true;
                dia1[row + i] = true;
                dia2[row - i + n - 1] = true;
                dfs(n, row + 1, res, col, dia1, dia2);
                col[i] = false;
                dia1[row + i] = false;
                dia2[row - i + n - 1] = false;
            }
        }
    }
}