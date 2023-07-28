class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int d = dist[x][y];
            if (x > 0 && grid[x - 1][y] != 2) {
                int d2 = d + (grid[x - 1][y] == 1 ? 1 : 0);
                if (d2 < dist[x - 1][y]) {
                    dist[x - 1][y] = d2;
                    queue.offer(new int[]{x - 1, y});
                }
            }
            if (x + 1 < m && grid[x + 1][y] != 2) {
                int d2 = d + (grid[x + 1][y] == 1 ? 1 : 0);
                if (d2 < dist[x + 1][y]) {
                    dist[x + 1][y] = d2;
                    queue.offer(new int[]{x + 1, y});
                }
            }
            if (y > 0 && grid[x][y - 1] != 2) {
                int d2 = d + (grid[x][y - 1] == 1 ? 1 : 0);
                if (d2 < dist[x][y - 1]) {
                    dist[x][y - 1] = d2;
                    queue.offer(new int[]{x, y - 1});
                }
            }
            if (y + 1 < n && grid[x][y + 1] != 2) {
                int d2 = d + (grid[x][y + 1] == 1 ? 1 : 0);
                if (d2 < dist[x][y + 1]) {
                    dist[x][y + 1] = d2;
                    queue.offer(new int[]{x, y + 1});
                }
            }
    }
}