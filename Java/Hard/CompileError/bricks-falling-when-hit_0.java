class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][hits[i][1]] -= 1;
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            grid[hits[i][0]][hits[i][1]] += 1;
            if (grid[hits[i][0]][hits[i][1]] == 1 && isStable(grid, hits[i][0], hits[i][1])) {
                result[i] = dfs(grid, hits[i][0], hits[i][1]) - 1;
            }
        }
        return result;
    }
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}