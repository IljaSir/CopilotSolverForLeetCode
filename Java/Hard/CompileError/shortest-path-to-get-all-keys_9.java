class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int startx = 0;
        int starty = 0;
        int maxMask = 0;
        int keyCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startx = i;
                    starty = j;
                } else if (c >= 'a' && c <= 'f') {
                    keyCount++;
                    maxMask |= (1 << (c - 'a'));
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startx, starty, 0});
        boolean[][][] visited = new boolean[m][n][64];
        visited[startx][starty][0] = true;
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int mask = cur[2];
                if (mask == maxMask) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    char c = grid[nx].charAt(ny);
                    if (c == '#') {
                        continue;
                    }
                    int nmask = mask;
                    if (c >= 'a' && c <= 'f') {
                        nmask |= (1 << (c - 'a'));
                    }
                    if (c >= 'A' && c <= 'F') {
                        if ((nmask & (1 << (c - 'A'))) == 0) {
                            continue;
                        }
                    }
                    if (!visited[nx
    }
}