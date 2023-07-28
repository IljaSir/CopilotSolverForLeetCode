class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int[][][] moves = new int[][][] {
            {{0, -1}, {0, 1}}, // horizontal
            {{-1, 0}, {1, 0}}, // vertical
            {{0, -1}, {1, 0}}, // top left
            {{0, 1}, {1, 0}}, // top right
            {{0, -1}, {-1, 0}}, // bottom left
            {{0, 1}, {-1, 0}}, // bottom right
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            if (x == m - 1 && y == n - 1) return true;
            int type = grid[x][y] - '1';
            for (int[] move : moves[type]) {
                int nx = x + move[0];
                int ny = y + move[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == 0) {
                    int ntype = grid[nx][ny] - '1';
                    for (int[] nmove : moves[ntype]) {
                        if (nx + nmove[0] == x && ny + nmove[1] == y) {
                            visited[nx][ny] = 1;
                            q.offer(new int[] {nx, ny});
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}