class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    total++;
                }
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                }
            }
        }
        return dfs(grid, sr, sc, er, ec, 0, total);
    }
    public int dfs(int[][] grid, int sr, int sc, int er, int ec, int count, int total) {
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == -1) {
            return 0;
        }
        if (grid[sr][sc] == 2) {
            if (count == total - 1) {
                return 1;
            } else {
                return 0;
            }
        }
        grid[sr][sc] = -1;
        int ans = dfs(grid, sr + 1, sc, er, ec, count + 1, total) + dfs(grid, sr - 1, sc, er, ec, count + 1, total) + dfs(grid, sr, sc + 1, er, ec, count + 1, total) + dfs(grid, sr, sc - 1, er, ec, count + 1, total);
        grid[sr][sc] = 0;
        return ans;
    }
}