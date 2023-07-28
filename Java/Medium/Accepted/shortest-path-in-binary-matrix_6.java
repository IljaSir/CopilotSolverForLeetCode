class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nx = x + i;
                    int ny = y + j;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 && distance[nx][ny] > distance[x][y] + 1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return distance[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : distance[n - 1][n - 1];
    }
}