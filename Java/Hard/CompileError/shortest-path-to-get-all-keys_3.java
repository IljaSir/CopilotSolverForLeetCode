class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int startx = 0;
        int starty = 0;
        int keys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    startx = i;
                    starty = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keys++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startx, starty, 0});
        boolean[][][] visited = new boolean[m][n][1 << keys];
        visited[startx][starty][0] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int k = cur[2];
                if (k == (1 << keys) - 1) {
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
                    int nk = k;
                    if (c >= 'a' && c <= 'f') {
                        nk = k | (1 << (c - 'a'));
                    }
                    if (c >= 'A' && c <= 'F' && ((nk >> (c - 'A')) & 1) == 0) {
                        continue;
                    }
                    if (visited[nx][ny][nk]) {
                        continue;
                    }
                    queue.offer(new int[]{nx, ny, nk});
                    visited[nx
    }
}