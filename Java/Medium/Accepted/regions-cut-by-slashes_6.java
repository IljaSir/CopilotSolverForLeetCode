class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        int[][] matrix = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (matrix[i][j] == 0) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix.length || matrix[i][j] != 0) {
            return;
        }
        matrix[i][j] = 1;
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);
    }
}