class Solution {
    public int minPushBox(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        int[] box = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'T') {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                }
            }
        }
        return bfs(grid, start, end, box);
    }

    private int bfs(char[][] grid, int[] start, int[] end, int[] box) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][][] visited = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        visited[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], box[0], box[1]});
        visited[start[0]][start[1]][box[0]][box[1]] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int bx = curr[2];
            int by = curr[3];
            if (bx == end[0] && by == end[1]) {
                return visited[x][y][bx][by];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nbx
    }
}