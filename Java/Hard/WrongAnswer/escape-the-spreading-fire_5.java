class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row: dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            int r = node[0], c = node[1];
            for (int[] dir: dirs) {
                int r1 = r + dir[0], c1 = c + dir[1];
                if (0 <= r1 && r1 < m && 0 <= c1 && c1 < n && grid[r1][c1] == 0 && dist[r1][c1] > dist[r][c] + 1) {
                    dist[r1][c1] = dist[r][c] + 1;
                    queue.add(new int[]{r1, c1});
                }
            }
        }
        int ans = 0;
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (grid[r][c] == 1)
                    for (int[] dir: dirs) {
                        int r1 = r + dir[0], c1 = c + dir[1];
                        if (0 <= r1 && r1 < m && 0 <= c1 && c1 < n && grid[r1][c1] == 0)
                            ans = Math.max(ans, dist[r1][c1]);
                    }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}