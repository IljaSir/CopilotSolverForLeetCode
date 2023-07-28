class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][][] dir = {
            {{1, 0}, {1, 1}, {1, -1}},
            {{-1, 0}, {-1, 1}, {-1, -1}},
            {{0, 1}, {1, 1}, {-1, 1}},
            {{0, -1}, {1, -1}, {-1, -1}}
        };
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            int[][] d = dir[grid[cur[0]][cur[1]] - '1'];
            for (int i = 0; i < d.length; i++) {
                int x = cur[0] + d[i][0];
                int y = cur[1] + d[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    for (int j = 0; j < dir[grid[x][y] - '1'].length; j++) {
                        int nx = x + dir[grid[x][y] - '1'][j][0];
                        int ny = y + dir[grid[x][y] - '1'][j][1];
                        if (nx == cur[0] && ny == cur[1]) {
                            q.offer(new int[]{x, y});
                            visited[x][y] = true;
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}