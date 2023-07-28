class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int lo = 0, hi = n * n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canReach(grid, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canReach(int[][] grid, int t) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] <= t) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return false;
    }
}