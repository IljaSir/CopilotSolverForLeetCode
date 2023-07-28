class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] size = new int[n * n + 2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int id = 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    size[id] = dfs(grid, i, j, id, dirs);
                    id++;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < id; ++i) {
            res = Math.max(res, size[i]);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> seen = new HashSet();
                    for (int[] dir : dirs) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            int idx = grid[nr][nc];
                            if (!seen.contains(idx)) {
                                seen.add(idx);
                                cur += size[idx];
                            }
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c, int id, int[][] dirs) {
        int n = grid.length;
        grid[r][c] = id;
        int res = 1;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                res += dfs(grid, nr, nc, id, dirs);
            }
        }
        return res;
    }
}