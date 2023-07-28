class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] start = new int[2], box = new int[2], target = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                } else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int[][][] seen = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(seen[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < 4; i++) {
            int[] next = new int[]{box[0] + dirs[i][0], box[1] + dirs[i][1]};
            if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && grid[next[0]][next[1]] != '#') {
                seen[box[0]][box[1]][i] = 0;
                q.offer(new int[]{box[0], box[1], i});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2];
            if (x == target[0] && y == target[1]) {
                return seen[x][y][dir];
            }
            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{x + dirs[i][0], y + dirs[i][1]};
    }
}