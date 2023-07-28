class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dir = new int[][][]{ {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {-1, 0}}, {{0, -1}, {-1, 0}} };
        int[][][] dir2 = new int[][][]{ {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}} };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            int[][] d = dir[grid[x][y] - '1'];
            for (int[] d1 : d) {
                int nx = x + d1[0];
                int ny = y + d1[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || !isValid(grid[x][y], grid[nx][ny], d1)) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return false;
    }
}