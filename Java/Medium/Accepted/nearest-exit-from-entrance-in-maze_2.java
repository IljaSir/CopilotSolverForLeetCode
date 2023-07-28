class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                if (maze[i][j] == '+') {
                    continue;
                }
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (!(i == entrance[0] && j == entrance[1])) {
                        return step;
                    }
                }
                maze[i][j] = '+';
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
                        q.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}