class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        int[][] grid = new int[1000000][1000000];
        for (int i = 0; i < blocked.length; i++) {
            grid[blocked[i][0]][blocked[i][1]] = -1;
        }
        return bfs(grid, source, target) && bfs(grid, target, source);
    }

    private boolean bfs(int[][] grid, int[] source, int[] target) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(source);
        grid[source[0]][source[1]] = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            if (count > 20000) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < 1000000 && y >= 0 && y < 1000000 && grid[x][y] == 0) {
                    if (x == target[0] && y == target[1]) {
                        return true;
                    }
                    grid[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}