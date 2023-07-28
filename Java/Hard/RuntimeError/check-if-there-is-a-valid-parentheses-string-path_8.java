class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dir = new int[][][] {{{0,1},{0,-1}},{{1,0},{-1,0}},{{0,1},{1,0}},{{0,-1},{1,0}},{{0,1},{-1,0}},{{0,-1},{-1,0}}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return true;
            }
            int type = grid[cur[0]][cur[1]] - '0' - 1;
            for (int[] d : dir[type]) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                int type2 = grid[x][y] - '0' - 1;
                for (int[] d2 : dir[type2]) {
                    if (d2[0] == -d[0] && d2[1] == -d[1]) {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                        break;
                    }
                }
            }
        }
        return false;
    }
}