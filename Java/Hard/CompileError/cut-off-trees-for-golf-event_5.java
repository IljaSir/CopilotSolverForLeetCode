class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = forest.get(i).get(j);
            }
        }
        int[][] dist = new int[m * n][m * n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 1) {
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        int d = dist[i * n + j][x * n + y];
                        if (grid[x][y] > 1 && grid[x][y] != grid[i][j]) {
                            dist[i * n + j][x * n + y] = d;
                            dist[x * n + y][i * n + j] = d;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] != 0) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                dist[i * n + j][nx * n + ny] = d + 1;
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        int cur = 0;
        boolean[] visited = new boolean[m * n];
        visited[0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)
    }
}