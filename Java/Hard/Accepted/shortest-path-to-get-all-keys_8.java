class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[][][] dist = new int[m][n][1 << 6];
        int si = -1, sj = -1;
        int totalKeys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c >= 'a' && c <= 'f') {
                    totalKeys |= 1 << (c - 'a');
                }
                if (c == '@') {
                    si = i;
                    sj = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj, 0});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int keys = cur[2];
                if (keys == totalKeys) {
                    return step;
                }
                if (dist[x][y][keys] != 0) {
                    continue;
                }
                dist[x][y][keys] = 1;
                for (int[] d : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
                        char c = grid[nx].charAt(ny);
                        if (c >= 'A' && c <= 'F') {
                            if ((keys & (1 << (c - 'A'))) == 0) {
                                continue;
                            }
                        }
                        int nkeys = keys;
                        if (c >= 'a' && c <= 'f') {
                            nkeys |= 1 << (c - 'a');
                        }
                        q.add(new int[]{nx, ny, nkeys});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}