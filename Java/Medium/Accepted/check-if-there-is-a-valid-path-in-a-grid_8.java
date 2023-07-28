class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dirs = new int[][][]{
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
        };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == m - 1 && c[1] == n - 1) {
                return true;
            }
            visited[c[0]][c[1]] = true;
            for (int[] dir : dirs[grid[c[0]][c[1]] - 1]) {
                int x = c[0] + dir[0];
                int y = c[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                for (int[] d : dirs[grid[x][y] - 1]) {
                    if (d[0] == -dir[0] && d[1] == -dir[1]) {
                        q.add(new int[]{x, y});
                        break;
                    }
                }
            }
        }
        return false;
    }
}