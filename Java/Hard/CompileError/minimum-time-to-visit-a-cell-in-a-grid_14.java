class Solution {
    public int minimumTime(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = dist[x][y];
            if (x > 0) {
                int time = Math.max(d, grid[x][y]) + grid[x - 1][y];
                if (time < dist[x - 1][y]) {
                    dist[x - 1][y] = time;
                    queue.add(new int[]{x - 1, y});
                }
            }
            if (x < m - 1) {
                int time = Math.max(d, grid[x][y]) + grid[x + 1][y];
                if (time < dist[x + 1][y]) {
                    dist[x + 1][y] = time;
                    queue.add(new int[]{x + 1, y});
                }];
    }
}