class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int[][] visited = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (isBorder(maze, cell[0], cell[1])) {
                if (cell[0] != entrance[0] || cell[1] != entrance[1]) {
                    return visited[cell[0]][cell[1]];
                }
            }
            for (int i = 0; i < 4; i++) {
                int r = cell[0] + dr[i];
                int c = cell[1] + dc[i];
                if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == '.' && visited[r][c] == Integer.MAX_VALUE) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = visited[cell[0]][cell[1]] + 1;
                }
            }
        }
        return -1;
    }
}