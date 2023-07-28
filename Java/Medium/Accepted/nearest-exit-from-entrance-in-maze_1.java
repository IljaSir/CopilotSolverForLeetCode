class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                if (visited[r][c]) continue;
                visited[r][c] = true;
                if ((r == 0 || r == m - 1 || c == 0 || c == n - 1) && !(r == entrance[0] && c == entrance[1])) return step;
                if (r - 1 >= 0 && maze[r - 1][c] == '.' && !visited[r - 1][c]) q.offer(new int[]{r - 1, c});
                if (r + 1 < m && maze[r + 1][c] == '.' && !visited[r + 1][c]) q.offer(new int[]{r + 1, c});
                if (c - 1 >= 0 && maze[r][c - 1] == '.' && !visited[r][c - 1]) q.offer(new int[]{r, c - 1});
                if (c + 1 < n && maze[r][c + 1] == '.' && !visited[r][c + 1]) q.offer(new int[]{r, c + 1});
            }
            step++;
        }
        return -1;
    }
}