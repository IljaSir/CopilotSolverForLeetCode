class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int[][] grid = new int[row][col];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int l = 0, r = cells.length, mid = l + (r - l) / 2, res = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] = 0;
                }
            }
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            boolean[][] visited = new boolean[row][col];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                if (grid[i][0] == 0) {
                    queue.add(new int[]{i, 0});
                    visited[i][0] = true;
                }
            }
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int[] d : dir) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && grid[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            boolean canCross = false;
            for (int i = 0; i < row; i++) {
                if (visited[i][col - 1]) {
                    canCross = true;
                    break;
                }
            }
            if (canCross) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}