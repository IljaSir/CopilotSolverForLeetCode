class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        int step = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == 0 || cur[0] == m - 1 || cur[1] == 0 || cur[1] == n - 1) {
                    if (!(cur[0] == entrance[0] && cur[1] == entrance[1])) {
                        return step;
                    }
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+' || visited[x][y]) {
                        continue;
                    }
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
}