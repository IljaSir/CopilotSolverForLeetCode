class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        int empty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        return dfs(grid, start, end, empty, m, n);
    }
    
    private int dfs(int[][] grid, int[] start, int[] end, int empty, int m, int n) {
        int i = start[0];
        int j = start[1];
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return empty == 0 ? 1 : 0;
        }
        grid[i][j] = -1;
        int res = dfs(grid, new int[]{i - 1, j}, end, empty - 1, m, n)
                + dfs(grid, new int[]{i + 1, j}, end, empty - 1, m, n)
                + dfs(grid, new int[]{i, j - 1}, end, empty - 1, m, n)
                + dfs(grid, new int[]{i, j + 1}, end, empty - 1, m, n);
        grid[i][j] = 0;
        return res;
    }
}