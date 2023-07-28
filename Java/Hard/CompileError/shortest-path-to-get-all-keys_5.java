class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int si = 0, sj = 0;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                } else if (c >= 'a' && c <= 'f') {
                    k = Math.max(k, c - 'a' + 1);
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int target = (1 << k) - 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{si, sj, 0});
        boolean[][][] visited = new boolean[m][n][1 << k];
        visited[si][sj][0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int keys = cur[2];
                if (keys == target) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
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
                    if (visited[nx][ny][nkeys]) {
                        continue;
                    }
                    visited[nx][ny][nkeys]
    }
}