class Solution {
    public int minimumTime(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int d = Math.max(dist[cur[0]][cur[1]], grid[x][y]);
                    if (d < dist[x][y]) {
                        dist[x][y] = d;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}