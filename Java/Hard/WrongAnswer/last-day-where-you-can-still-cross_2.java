class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int[][] grid = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            if (isConnected(grid)) {
                return cells.length - i - 1;
            }
        }
        return 0;
    }
    private boolean isConnected(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] == col - 1) {
                return true;
            }
            for (int[] dir: new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
}