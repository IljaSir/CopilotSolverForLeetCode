class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dir = new int[][][]{
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}},
            {{0, 1}, {-1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {1, 0}}
        };
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            if (visited[cur[0]][cur[1]] == 1) {
                continue;
            }
            visited[cur[0]][cur[1]] = 1;
            for (int[] d : dir[grid[cur[0]][cur[1]] - 1]) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (visited[x][y] == 1) {
                    continue;
                }
                boolean flag = false;
                for (int[] d2 : dir[grid[x][y] - 1]) {
                    if (d2[0] == -d[0] && d2[1] == -d[1]) {
                        flag = true;
                    }
                }
                if (flag) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}