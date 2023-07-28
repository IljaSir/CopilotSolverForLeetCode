class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];
            if (visited[cr][cc] > 0) {
                continue;
            }
            visited[cr][cc] = 1;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (maze[nr][nc] == '+') {
                    continue;
                }
                if (visited[nr][nc] > 0) {
                    continue;
                }
                if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                    return visited[cr][cc];
                }
                queue.offer(new int[]{nr, nc});
            }
        }
        return -1;
    }
}