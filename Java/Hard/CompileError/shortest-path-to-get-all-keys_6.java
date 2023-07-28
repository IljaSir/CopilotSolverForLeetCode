class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length, n = grid[0].length();
        int[][][] dist = new int[m][n][1 << 6];
        int[] start = new int[2];
        int target = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
                char c = grid[i].charAt(j);
                if (c == '@') {
                    start[0] = i;
                    start[1] = j;
                } else if (c >= 'a' && c <= 'f') {
                    target |= (1 << (c - 'a'));
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]][0] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], keys = curr[2];
            if (keys == target) {
                return dist[x][y][keys];
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    char c = grid[nx].charAt(ny);
                    if (c == '#') {
                        continue;
                    }
                    int nkeys = keys;
                    if (c >= 'a' && c <= 'f') {
                        nkeys |= (1 << (c - 'a'));
                    }
                    if (c >= 'A' && c <= 'F' && ((nkeys >> (c - 'A')) & 1) == 0) {
                        continue;
                    }
                    if (dist[nx][ny][nkeys] > dist[x][y][keys] + 1) {
                        dist[nx][ny][nkeys] = dist[x][y][keys] + 1;
                        q.offer(new int[]{nx, ny, nkeys});
    }
}