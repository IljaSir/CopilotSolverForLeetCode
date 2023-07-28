class Solution {
    public int largestIsland(int[][] grid) {
        
        int N = grid.length;
        int[] area = new int[N*N+2];
        int idx = 2;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (grid[i][j] == 1)
                    area[idx] = dfs(grid, i, j, idx++);

        int ans = 0;
        for (int x: area) ans = Math.max(ans, x);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet();
                    for (int nei: neighbors(grid, i, j)) {
                        seen.add(nei);
                        ans = Math.max(ans, 1 + area[nei]);
                    }
                }

        return ans;
    }

    public int dfs(int[][] grid, int r, int c, int idx) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid.length && grid[r][c] == 1) {
            grid[r][c] = idx;
            return 1 + dfs(grid, r+1, c, idx) + dfs(grid, r-1, c, idx) + dfs(grid, r, c+1, idx) + dfs(grid, r, c-1, idx);
        }
        return 0;
    }
}