class Solution {
    public int minimumMoves(int[][] grid) {
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1, 0});
        boolean[][][] visited = new boolean[n][n][2];
        visited[0][1][0] = true;
        int res = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x1 = cur[0], y1 = cur[1], d = cur[2];
                if (x1 == n - 1 && y1 == n - 2 && d == 0) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    int x2 = x1 + dirs[j][0], y2 = y1 + dirs[j][1];
                    if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= n || grid[x2][y2] == 1) {
                        continue;
                    }
                    if (d == 0 && x2 + 1 < n && grid[x2 + 1][y2] == 0) {
                        if (!visited[x2][y2][d]) {
                            queue.offer(new int[]{x2, y2, d});
                            visited[x2][y2][d] = true;
                        }
                    }
                    if (d == 1 && y2 + 1 < n && grid[x2][y2 + 1] == 0) {
                        if (!visited[x2][y2][d]) {
                            queue.offer(new int[]{x2, y2, d});
                            visited[x2][y2][d] = true;
                        }
                    }
                }
                int x2 = x1, y2 = y1, d2 = d ^ 1;
                if (d2 == 0 && x2 + 1 < n && grid[x2 + 1][y2] == 0 && grid[x2 + 1][y2 + 1] == 0) {
                    if (!visited[x2][y2][
    }
}