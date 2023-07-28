class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length, n = grid[0].length();
        int[][][] dist = new int[m][n][1 << 6];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        int[] start = new int[3];
        int keys = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '@') {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keys++;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        dist[start[0]][start[1]][0] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], k = cur[2];
            if (k == (1 << keys) - 1) {
                return dist[x][y][k];
            }
            for (int[] d : dirs) {
                int i = x + d[0], j = y + d[1], nk = k;
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i].charAt(j) == '#') {
                    continue;
                }
                if (grid[i].charAt(j) >= 'A' && grid[i].charAt(j) <= 'F' && ((k >> (grid[i].charAt(j) - 'A')) & 1) == 0) {
                    continue;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    nk |= (1 << (grid[i].charAt(j) - 'a'));
                }
                if (dist[i][j][nk] > dist[x][y][
    }
}