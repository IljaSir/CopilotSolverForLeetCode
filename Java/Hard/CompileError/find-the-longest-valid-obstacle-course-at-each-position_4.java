class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        
        int[][] grid = new int[row][col];
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        int left = 0, right = cells.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            for (int i = 0; i <= mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            if (dfs(grid, 0, 0)) {
                left = mid + 1;
            } else {
                right = mid;
            }
            for (int i = 0; i <= mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 0;
            }
        }
        return left;
    }
    public boolean dfs(int[][] grid, int r, int c) {
        if (r == grid.length - 1) {
            return true;
        }
        grid[r][c] = 2;
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != 0) {
                continue;
            }
            if (dfs(grid, nr, nc)) {
                return true;
            }
        }
        return false;
    }
}