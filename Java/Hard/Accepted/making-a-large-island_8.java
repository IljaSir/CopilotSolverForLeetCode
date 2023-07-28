class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] areas = new int[n * n + 2];
        int index = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areas[index] = dfs(grid, i, j, index, dirs);
                    index++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> seen = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1 && !seen.contains(grid[x][y])) {
                            area += areas[grid[x][y]];
                            seen.add(grid[x][y]);
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans == 0 ? n * n : ans;
    }
    
    private int dfs(int[][] grid, int i, int j, int index, int[][] dirs) {
        grid[i][j] = index;
        int area = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 1) {
                area += dfs(grid, x, y, index, dirs);
            }
        }
        return area;
    }
}