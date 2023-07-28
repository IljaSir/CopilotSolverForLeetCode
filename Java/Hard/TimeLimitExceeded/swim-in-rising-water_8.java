class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int t = 0;
        int[][] visited = new int[n][n];
        while (true) {
            if (grid[0][0] <= t) {
                visited[0][0] = 1;
                Queue<int[]> q = new LinkedList();
                q.offer(new int[]{0, 0});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    if (cur[0] == n - 1 && cur[1] == n - 1) return t;
                    for (int[] dir : dirs) {
                        int nx = cur[0] + dir[0];
                        int ny = cur[1] + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0 && grid[nx][ny] <= t) {
                            visited[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            t++;
        }
    }
}