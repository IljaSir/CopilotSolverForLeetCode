class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        boolean[][] visited1 = new boolean[m][n];
        int[][] dist = new int[m][n];
        int[][] dist1 = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q1 = new LinkedList<>();
        q.add(new int[]{0, 0});
        q1.add(new int[]{m - 1, n - 1});
        visited[0][0] = true;
        visited1[m - 1][n - 1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited1[x][y]) {
                    visited1[x][y] = true;
                    dist1[x][y] = dist1[cur[0]][cur[1]] + 1;
                    q1.add(new int[]{x, y});
                }
            }
        }
        if (dist[m - 1][n - 1] == m + n - 2) {
            return false;
        }
        for (int i = 0; i < m; i++)
    }
}