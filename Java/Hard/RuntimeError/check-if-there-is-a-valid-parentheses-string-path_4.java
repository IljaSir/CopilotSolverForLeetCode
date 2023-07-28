class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dir = new int[][][] {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
        };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            int[][] d = dir[grid[cur[0]][cur[1]] - '1'];
            for (int[] dd : d) {
                int x = cur[0] + dd[0];
                int y = cur[1] + dd[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    int[][] dd2 = dir[grid[x][y] - '1'];
                    for (int[] dd3 : dd2) {
                        if (dd3[0] + dd[0] == 0 && dd3[1] + dd[1] == 0) {
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}