class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            if (grid[x][y] == 1) {
                continue;
            }
            int d = dist[x][y];
            for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int i = x + dir[0], j = y + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 1 && d + 1 < dist[i][j]) {
                    dist[i][j] = d + 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int d = Integer.MAX_VALUE;
                    for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1) {
                            d = Math.min(d, dist[x][y]);
                        }
                    }
                    if (d < Integer.MAX_VALUE) {
                        max = Math.max(max, d + 1);
                    }
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}