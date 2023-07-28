class Solution {
    public int totalNQueens(int n) {
        
        int[] result = new int[1];
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        dfs(result, cols, d1, d2, 0, n);
        return result[0];
    }
    private void dfs(int[] result, boolean[] cols, boolean[] d1, boolean[] d2, int row, int n) {
        if (row == n) {
            result[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row + col;
            int id2 = row - col + n - 1;
            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            dfs(result, cols, d1, d2, row + 1, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}