class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = mat[i][j] == 0 ? 0 : 10000;
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || dist[x][y] <= dist[cur[0]][cur[1]] + 1) {
                    continue;
                }
                dist[x][y] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[] {x, y});
            }
        }
        return dist;
    }
}