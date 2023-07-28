class Solution {
    public int numberOfCombinations(String num) {
        
        int left = 1, right = cells.length;
        int[][] grid = new int[row][col];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            for (int i = 0; i < row; i++) {
                Arrays.fill(grid[i], 0);
            }
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            if (dfs(grid, 0, 0)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        if (i == row - 1) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 1) {
            return false;
        }
        grid[i][j] = 1;
        boolean res = dfs(grid, i + 1, j) || dfs(grid, i - 1, j) || dfs(grid, i, j + 1) || dfs(grid, i, j - 1);
        grid[i][j] = 0;
        return res;
    }
}